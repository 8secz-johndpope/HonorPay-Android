package com.freeworldone.honorpay.ui.base.extensions

import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

fun Disposable.disposeBy(disposables: CompositeDisposable): Disposable = apply { disposables.add(this) }

fun Completable.observeOnMain(): Completable = observeOn(AndroidSchedulers.mainThread())
//fun Completable.computations(): Completable = observeOn(Schedulers.computation())

//fun Completable.subscribeComputations(): Completable = subscribeOn(Schedulers.computation())
fun Completable.subscribeIo(): Completable = subscribeOn(Schedulers.io())

fun <T> Flowable<T>.observeOnMain(): Flowable<T> = observeOn(AndroidSchedulers.mainThread())
//fun <T> Flowable<T>.computations(): Flowable<T> = observeOn(Schedulers.computation())
//fun <T> Flowable<T>.subscribeComputations(): Flowable<T> = subscribeOn(Schedulers.computation())
//fun <T> Flowable<T>.subscribeIo(): Flowable<T> = subscribeOn(Schedulers.io())

fun <T> Maybe<T>.observeOnMain(): Maybe<T> = observeOn(AndroidSchedulers.mainThread())
//fun <T> Maybe<T>.computations(): Maybe<T> = observeOn(Schedulers.computation())
//fun <T> Maybe<T>.subscribeComputations(): Maybe<T> = subscribeOn(Schedulers.computation())
//fun <T> Maybe<T>.subscribeIo(): Maybe<T> = subscribeOn(Schedulers.io())

fun <T, R> Maybe<T>.mapMaybeNull(f: (it: T) -> R?): Maybe<R> = flatMap { item ->
    Maybe.create<R> { emitter -> f(item)?.let { emitter.onSuccess(it) } ?: emitter.onComplete() }
}

fun <T> Observable<T>.observeOnMain(): Observable<T> = observeOn(AndroidSchedulers.mainThread())
//fun <T> Observable<T>.computations(): Observable<T> = observeOn(Schedulers.computation())
//fun <T> Observable<T>.sql(db: AppDatabase, f: AppDatabase.(it: T) -> Unit): Observable<T> = observeOn(Schedulers.io()).doOnNext { db.runInTransaction { db.f(it) } }
fun <T> Observable<T>.subscribeComputations(): Observable<T> = subscribeOn(Schedulers.computation())
//fun <T> Observable<T>.subscribeIo(): Observable<T> = subscribeOn(Schedulers.io())

fun <T> Single<T>.observeOnMain(): Single<T> = observeOn(AndroidSchedulers.mainThread())
//fun <T> Single<T>.computations(): Observable<T> = observeOn(Schedulers.computation())

fun <T> Single<T>.subscribeComputations(): Single<T> = subscribeOn(Schedulers.computation())
fun <T> Single<T>.subscribeIo(): Single<T> = subscribeOn(Schedulers.io())