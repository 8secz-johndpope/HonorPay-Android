package com.freeworldone.honorpay.domain

import com.freeworldone.honorpay.BuildConfig
import com.freeworldone.honorpay.data.enums.UserType
import com.freeworldone.honorpay.domain.models.body.AwardBody
import com.freeworldone.honorpay.domain.models.body.RegisterGhostBody
import com.freeworldone.honorpay.domain.models.body.UpdateBody
import com.freeworldone.honorpay.domain.models.body.UploadProfilePicBody
import com.freeworldone.honorpay.domain.models.response.*
import com.freeworldone.honorpay.domain.typeadapters.DateAdapter
import com.freeworldone.honorpay.ui.base.extensions.subscribeIo
import com.squareup.moshi.Moshi
import io.reactivex.Completable
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*

object RestAdapter {
    private val api: Api = Retrofit.Builder()
            .baseUrl("https://honorpay.org/api/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().add(DateAdapter()).build()))
            .client(OkHttpClient.Builder().apply {
                addInterceptor { chain ->
                    val request = chain.request()
                    chain.proceed(request.newBuilder()
                            .apply {
                                header("User-Agent", "HonorPay/${BuildConfig.VERSION_CODE} ${System.getProperty("http.agent")}")
                                method(request.method(), request.body())
                            }.build())
                }
                if (BuildConfig.DEBUG) addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
//                addInterceptor(LoggingInterceptor.Builder()
//                        .loggable(BuildConfig.DEBUG)
//                        .addHeader("User-Agent", "HonorPay/${BuildConfig.VERSION_CODE} ${System.getProperty("http.agent")}")
//                        .setLevel(Level.BASIC)
//                        .build())
            }.build())
            .build()
            .create(Api::class.java)

    interface Api {

        @POST("award")
        fun award(@Body awardBody: AwardBody): Single<AwardResponse>

        @GET("login")
        fun login(@Query("e") email: String, @Query("p") password: String): Single<LoginResponse>

        @GET("recent")
        fun recent(@Query("page") page: Int): Single<List<RecentResponse>>

        @GET("newuser")
        fun newUser(@Query("first_name") firstName: String,
                    @Query("last_name") lastName: String,
                    @Query("nickname") nickname: String?,
                    @Query("region") region: String,
                    @Query("country") country: String,
                    @Query("attributes") attributes: String,
                    @Query("email") email: String,
                    @Query("password") password: String,
                    @Query("signature") signature: String?,
                    @Query("type") userType: Int,
                    @Query("notifications") notificationsAllowed: Int,
                    @Query("reminders") remindersAllowed: Int): Single<NewUserResponse>

        @POST("registerGhost")
        fun registerGhost(@Body registerGhostBody: RegisterGhostBody): Single<RegisterGhostResponse>

        @GET("search")
        fun search(@Query("q") txt: String): Single<SearchResponse>

        @PUT("update")
        fun update(@Body updateBody: UpdateBody): Completable

        @POST("uploadProfilePic")
        fun uploadProfilePic(@Body uploadProfilePicBody: UploadProfilePicBody): Single<UploadProfilePicResponse>

        @GET("getuser")
        fun user(@Query("id") id: Int): Single<UserResponse>
    }

    fun award(awardBody: AwardBody): Single<AwardResponse> = api.award(awardBody).subscribeIo()

    fun login(email: String, password: String): Single<LoginResponse> = api.login(email, password).subscribeIo()

    fun recent(): Single<List<RecentResponse>> = api.recent(1).subscribeIo()

    fun newUser(firstName: String,
                lastName: String,
                nickname: String? = null,
                region: String,
                country: String,
                attributes: String,
                email: String,
                password: String,
                signature: String? = null,
                userType: UserType = UserType.UNCONFIRMED,
                notificationsAllowed: Boolean,
                remindersAllowed: Boolean): Single<NewUserResponse> = api.newUser(
            firstName = firstName,
            lastName = lastName,
            nickname = nickname,
            region = region,
            country = country,
            attributes = attributes,
            email = email,
            password = password,
            signature = signature,
            userType = userType.type,
            notificationsAllowed = if (notificationsAllowed) 1 else 0,
            remindersAllowed = if (remindersAllowed) 1 else 0)
            .subscribeIo()

    fun registerGhost(registerGhostBody: RegisterGhostBody): Single<RegisterGhostResponse> = api.registerGhost(registerGhostBody).subscribeIo()

    fun search(txt: String): Single<SearchResponse> = api.search(txt).subscribeIo()

    fun update(updateBody: UpdateBody): Completable = api.update(updateBody).subscribeIo()

    fun uploadProfilePic(uploadProfilePicBody: UploadProfilePicBody): Single<UploadProfilePicResponse> = api.uploadProfilePic(uploadProfilePicBody).subscribeIo()

    fun user(id: Int): Single<UserResponse> = api.user(id).subscribeIo()
}