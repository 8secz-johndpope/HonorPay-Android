package com.freeworldone.honorpay.domain

import com.freeworldone.honorpay.BuildConfig
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

object RestAdapter {
    var authToken: String? = null
        private set

    private val api: Api = Retrofit.Builder()
            .baseUrl("https://honorpay.org/")
//            .addCallAdapterFactory(RxJava2CallAdapter.Factory(Schedulers.io()))
            .addConverterFactory(GsonConverterFactory.create(Gson())) //TODO: check gson initialization & settings
            .client(OkHttpClient.Builder().apply {
                addInterceptor { chain ->
                    val request = chain.request()
                    chain.proceed(request.newBuilder()
                            .apply {
                                header("X-HonorPay-Platform", "Android")
                                header("X-HonorPay-Version", BuildConfig.VERSION_NAME)
                                method(request.method(), request.body())
                            }.build())
                }
                if (BuildConfig.DEBUG) addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
            }.build())
            .build()
            .create(Api::class.java)

    interface Api {
        @GET("search?q={txt}")
        fun search(@Path("txt") txt: String) //: Single<SearchResponse>
    }

    fun search(txt: String) /* : Single<SearchResponse>*/ {
        return api.search(txt)
    }
}