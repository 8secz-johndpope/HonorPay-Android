package com.freeworldone.honorpay.domain

import com.freeworldone.honorpay.BuildConfig
import com.freeworldone.honorpay.data.enums.UserType
import com.freeworldone.honorpay.domain.models.Result
import com.freeworldone.honorpay.domain.models.body.AwardBody
import com.freeworldone.honorpay.domain.models.body.RegisterGhostBody
import com.freeworldone.honorpay.domain.models.body.UpdateBody
import com.freeworldone.honorpay.domain.models.body.UploadProfilePicBody
import com.freeworldone.honorpay.domain.models.response.*
import com.freeworldone.honorpay.domain.models.result
import com.freeworldone.honorpay.domain.typeadapters.DateAdapter
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*

object RestAdapter {
    private val api: Api = Retrofit.Builder()
            .baseUrl("https://honorpay.org/api/")
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
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
        fun award(@Body awardBody: AwardBody): Deferred<AwardResponse>

        @GET("login")
        fun login(@Query("e") email: String, @Query("p") password: String): Deferred<LoginResponse>

        @GET("recent")
        fun recent(@Query("page") page: Int): Deferred<List<RecentResponse>>

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
                    @Query("reminders") remindersAllowed: Int): Deferred<NewUserResponse>

        @POST("registerGhost")
        fun registerGhost(@Body registerGhostBody: RegisterGhostBody): Deferred<RegisterGhostResponse>

        @GET("search")
        fun search(@Query("q") txt: String): Deferred<SearchResponse>

        @PUT("update")
        fun update(@Body updateBody: UpdateBody): Deferred<Nothing>

        @POST("uploadProfilePic")
        fun uploadProfilePic(@Body uploadProfilePicBody: UploadProfilePicBody): Deferred<UploadProfilePicResponse>

        @GET("getuser")
        fun user(@Query("id") id: Int): Deferred<UserResponse>
    }

    suspend fun award(awardBody: AwardBody): Result<AwardResponse> = api.award(awardBody).result()

    suspend fun login(email: String, password: String): Result<LoginResponse> = api.login(email, password).result()

    suspend fun recent(): Result<List<RecentResponse>> = api.recent(1).result()

    suspend fun newUser(firstName: String,
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
                        remindersAllowed: Boolean): Result<NewUserResponse> = api.newUser(
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
            remindersAllowed = if (remindersAllowed) 1 else 0).result()

    suspend fun registerGhost(registerGhostBody: RegisterGhostBody): Result<RegisterGhostResponse> = api.registerGhost(registerGhostBody).result()

    suspend fun search(txt: String): Result<SearchResponse> = api.search(txt).result()

    suspend fun update(updateBody: UpdateBody): Result<Nothing> = api.update(updateBody).result()

    suspend fun uploadProfilePic(uploadProfilePicBody: UploadProfilePicBody): Result<UploadProfilePicResponse> = api.uploadProfilePic(uploadProfilePicBody).result()

    suspend fun user(id: Int): Result<UserResponse> = api.user(id).result()
}