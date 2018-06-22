package com.freeworldone.honorpay.domain

import com.freeworldone.honorpay.BuildConfig
import com.freeworldone.honorpay.domain.models.body.*
import com.freeworldone.honorpay.domain.models.response.*
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

object RestAdapter {
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

        @POST("award")
        fun award(@Body awardBody: AwardBody): Call<AwardResponse>

        @POST("login")
        fun login(@Body loginBody: LoginBody): Call<LoginResponse>

        @GET("recent")
        fun recent(): Call<RecentResponse>

        @POST("register")
        fun register(@Body registerBody: RegisterBody): Call<RegisterResponse>

        @POST("registerGhost")
        fun registerGhost(@Body registerGhostBody: RegisterGhostBody): Call<RegisterGhostResponse>

        @GET("search?q={txt}")
        fun search(@Path("txt") txt: String): Call<SearchResponse> //: Single<SearchResponse>

        @PUT("update")
        fun update(@Body updateBody: UpdateBody): Call<Void>

        @POST("uploadProfilePic")
        fun uploadProfilePic(@Body uploadProfilePicBody: UploadProfilePicBody): Call<UploadProfilePicResponse>

        @GET("user?id={id}")
        fun user(@Path("id") id: Int): Call<UserResponse>
    }

    fun award(awardBody: AwardBody): Call<AwardResponse> = api.award(awardBody)

    fun login(loginBody: LoginBody): Call<LoginResponse> = api.login(loginBody)

    fun recent(): Call<RecentResponse> = api.recent()

    fun register(registerBody: RegisterBody): Call<RegisterResponse> = api.register(registerBody)

    fun registerGhost(registerGhostBody: RegisterGhostBody): Call<RegisterGhostResponse> = api.registerGhost(registerGhostBody)

    fun search(txt: String): Call<SearchResponse> = api.search(txt)

    fun update(updateBody: UpdateBody): Call<Void> = api.update(updateBody)

    fun uploadProfilePic(uploadProfilePicBody: UploadProfilePicBody): Call<UploadProfilePicResponse> = api.uploadProfilePic(uploadProfilePicBody)

    fun user(id: Int): Call<UserResponse> = api.user(id)
}