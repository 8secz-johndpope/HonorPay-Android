package com.freeworldone.honorpay.domain.util

//import io.reactivex.*
//import io.reactivex.disposables.Disposable
//import io.reactivex.exceptions.CompositeException
//import io.reactivex.exceptions.Exceptions
//import io.reactivex.plugins.RxJavaPlugins
//import retrofit2.*
//import java.lang.reflect.ParameterizedType
//import java.lang.reflect.Type
//
//
//class RxJava2CallAdapter<R> private constructor(private val responseType: Type, private val scheduler: Scheduler,
//                                                private val callType: Int, private val observableType: String) : CallAdapter<R, Any> {
//
//    override fun responseType(): Type = responseType
//
//    override fun adapt(call: Call<R>): Any {
//        val responseObservable = CallExecuteObservable(call)
//        val observable = when (callType) {
//            RESULT -> ResultObservable(responseObservable)
//            BODY -> BodyObservable(responseObservable)
//            else -> responseObservable
//        }.subscribeOn(scheduler)
//        return when (observableType) {
//            OBSERVABLE -> observable
//            FLOWABLE -> observable.toFlowable(BackpressureStrategy.LATEST)
//            SINGLE -> observable.singleOrError()
//            MAYBE -> observable.singleElement()
//            COMPLETABLE -> observable.ignoreElements()
//            else -> throw IllegalArgumentException("Invalid observableType in RxJava2CallAdapter: $observableType")
//        }
//    }
//
//    companion object {
//        private const val OBSERVABLE = "Observable"
//        private const val COMPLETABLE = "Completable"
//        private const val FLOWABLE = "Flowable"
//        private const val MAYBE = "Maybe"
//        private const val SINGLE = "Single"
//
//        private const val RESPONSE = 1
//        private const val RESULT = 2
//        private const val BODY = 3
//
//    }
//
//    /**
//     * Returns an instance which creates synchronous observables that
//     * [subscribe on][Observable.subscribeOn] `scheduler` by default.
//     */
//    class Factory(private val scheduler: Scheduler) : CallAdapter.Factory() {
//
//        override fun get(returnType: Type, annotations: Array<Annotation>, retrofit: Retrofit): CallAdapter<*, *>? {
//            val rawType = CallAdapter.Factory.getRawType(returnType)
//            // Completable is not parameterized (which is what the rest of this method deals with) so it can only be created with a single configuration.
//            val oType = when (rawType) {
//                Completable::class.java -> return RxJava2CallAdapter<Void>(Void::class.java, scheduler, BODY, COMPLETABLE)
//                Flowable::class.java -> FLOWABLE
//                Single::class.java -> SINGLE
//                Maybe::class.java -> MAYBE
//                Observable::class.java -> OBSERVABLE
//                else -> return null
//            }
//
//            if (returnType !is ParameterizedType) throw IllegalStateException("$oType return type must be parameterized as $oType<Foo> or $oType<? : Foo>")
//            val responseType = CallAdapter.Factory.getParameterUpperBound(0, returnType)
//            val rawResponseType = CallAdapter.Factory.getRawType(responseType)
//
//            return when (rawResponseType) {
//                Response::class.java -> {
//                    if (responseType !is ParameterizedType) throw IllegalStateException("Response must be parameterized as Response<Foo> or Response<? : Foo>")
//                    RxJava2CallAdapter<Any>(getParameterUpperBound(0, responseType), scheduler, RESPONSE, oType)
//                }
//                Result::class.java -> {
//                    if (responseType !is ParameterizedType) throw IllegalStateException("Result must be parameterized as Result<Foo> or Result<? : Foo>")
//                    RxJava2CallAdapter<Any>(getParameterUpperBound(0, responseType), scheduler, RESULT, oType)
//                }
//                else -> RxJava2CallAdapter<Any>(responseType, scheduler, BODY, oType)
//            }
//        }
//    }
//
//    internal class CallExecuteObservable<T>(private val originalCall: Call<T>) : Observable<Response<T>>() {
//
//        override fun subscribeActual(observer: Observer<in Response<T>>) {
//            // Since Call is a one-shot type, clone it for each new observer.
//            val call = originalCall.clone()
//            val disposable = CallDisposable(call)
//            observer.onSubscribe(disposable)
//
//            var terminated = false
//            try {
//                val response = call.execute()
//                if (!disposable.isDisposed) {
//                    observer.onNext(response)
//                }
//                if (!disposable.isDisposed) {
//                    terminated = true
//                    observer.onComplete()
//                }
//            } catch (t: Throwable) {
//                Exceptions.throwIfFatal(t)
//                if (terminated) RxJavaPlugins.onError(t)
//                else if (!disposable.isDisposed) try {
//                    observer.onError(t)
//                } catch (inner: Throwable) {
//                    Exceptions.throwIfFatal(inner)
//                    RxJavaPlugins.onError(CompositeException(t, inner))
//                }
//            }
//        }
//
//        internal class CallDisposable internal constructor(private val call: Call<*>) : Disposable {
//            @Volatile
//            private var disposed: Boolean = false
//
//            override fun dispose() {
//                disposed = true
//                call.cancel()
//            }
//
//            override fun isDisposed(): Boolean = disposed
//        }
//    }
//
//    internal class ResultObservable<T>(private val upstream: Observable<Response<T>>) : Observable<Result<T>>() {
//
//        override fun subscribeActual(observer: Observer<in Result<T>>) {
//            upstream.subscribe(ResultObserver(observer))
//        }
//
//        internal class ResultObserver<R>(private val observer: Observer<in Result<R>>) : Observer<Response<R>> {
//
//            override fun onSubscribe(disposable: Disposable) {
//                observer.onSubscribe(disposable)
//            }
//
//            override fun onNext(response: Response<R>) {
//                observer.onNext(Result.Success(response))
//            }
//
//            override fun onComplete() {
//                observer.onComplete()
//            }
//
//            override fun onError(throwable: Throwable) {
//                try {
//                    observer.onNext(Result.Error(throwable))
//                } catch (t: Throwable) {
//                    try {
//                        observer.onError(t)
//                    } catch (inner: Throwable) {
//                        Exceptions.throwIfFatal(inner)
//                        RxJavaPlugins.onError(CompositeException(t, inner))
//                    }
//                    return
//                }
//                observer.onComplete()
//            }
//        }
//    }
//
//    internal class BodyObservable<T>(private val upstream: Observable<Response<T>>) : Observable<T>() {
//
//        override fun subscribeActual(observer: Observer<in T>) {
//            upstream.subscribe(BodyObserver(observer))
//        }
//
//        internal class BodyObserver<R>(private val observer: Observer<in R>) : Observer<Response<R>> {
//            private var terminated: Boolean = false
//
//            override fun onSubscribe(disposable: Disposable) {
//                observer.onSubscribe(disposable)
//            }
//
//            override fun onNext(response: Response<R>) {
//                val body = response.body()
//                if (response.isSuccessful) {
//                    if (body == null) observer.onComplete()
//                    else observer.onNext(body)
//                } else {
//                    terminated = true
//                    val t = NetworkException(HttpException(response))
//                    try {
//                        observer.onError(t)
//                    } catch (inner: Throwable) {
//                        Exceptions.throwIfFatal(inner)
//                        RxJavaPlugins.onError(CompositeException(t, inner))
//                    }
//                }
//            }
//
//            override fun onComplete() {
//                if (!terminated) observer.onComplete()
//            }
//
//            override fun onError(throwable: Throwable) {
//                if (!terminated) observer.onError(throwable)
//                else {
//                    val broken = AssertionError("This should never happen! Report as a bug with the full stacktrace.")
//                    broken.initCause(throwable)
//                    RxJavaPlugins.onError(broken)
//                }
//            }
//        }
//    }
//
//    @Suppress("unused")
//    sealed class Result<T> {
//        class Error<T>(val throwable: Throwable) : Result<T>()
//        class Success<T>(val response: Response<T>) : Result<T>()
//    }
//}