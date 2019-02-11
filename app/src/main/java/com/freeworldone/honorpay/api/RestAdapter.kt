package com.freeworldone.honorpay.api

import com.freeworldone.honorpay.BuildConfig
import com.freeworldone.honorpay.api.models.Result
import com.freeworldone.honorpay.api.models.body.AwardBody
import com.freeworldone.honorpay.api.models.body.RegisterGhostBody
import com.freeworldone.honorpay.api.models.body.UpdateBody
import com.freeworldone.honorpay.api.models.body.UploadProfilePicBody
import com.freeworldone.honorpay.api.typeadapters.DateAdapter
import com.freeworldone.honorpay.data.enums.UserType
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

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

    suspend fun award(awardBody: AwardBody) = api.award(awardBody)

    suspend fun login(email: String, password: String) = api.login(email, password)

    suspend fun recent() = api.recent(1)

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
                        remindersAllowed: Boolean) = api.newUser(
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

    suspend fun registerGhost(registerGhostBody: RegisterGhostBody) = api.registerGhost(registerGhostBody)

    suspend fun search(txt: String) = api.search(txt)

    suspend fun update(updateBody: UpdateBody): Result<Nothing> = api.update(updateBody)

    suspend fun uploadProfilePic(uploadProfilePicBody: UploadProfilePicBody) = api.uploadProfilePic(uploadProfilePicBody)

    suspend fun user(id: Int) = api.user(id)
}