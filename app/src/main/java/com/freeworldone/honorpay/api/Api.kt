package com.freeworldone.honorpay.api

import com.freeworldone.honorpay.api.models.body.AwardBody
import com.freeworldone.honorpay.api.models.body.RegisterGhostBody
import com.freeworldone.honorpay.api.models.body.UpdateBody
import com.freeworldone.honorpay.api.models.body.UploadProfilePicBody
import com.freeworldone.honorpay.api.models.response.LoginResponse
import com.freeworldone.honorpay.api.models.response.NewUserResponse
import com.freeworldone.honorpay.api.models.response.RegisterGhostResponse
import com.freeworldone.honorpay.api.models.response.UploadProfilePicResponse
import com.freeworldone.honorpay.data.models.Award
import com.freeworldone.honorpay.data.models.Recent
import com.freeworldone.honorpay.data.models.User
import retrofit2.http.*

interface Api {

    @POST("award")
    suspend fun award(@Body awardBody: AwardBody): Award

    @GET("login")
    suspend fun login(@Query("e") email: String, @Query("p") password: String): LoginResponse

    @GET("recent")
    suspend fun recent(@Query("page") page: Int): List<Recent>

    @GET("newuser")
    suspend fun newUser(@Query("first_name") firstName: String,
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
                        @Query("reminders") remindersAllowed: Int): NewUserResponse

    @POST("registerGhost")
    suspend fun registerGhost(@Body registerGhostBody: RegisterGhostBody): RegisterGhostResponse

    @GET("search")
    suspend fun search(@Query("q") txt: String): List<User>

    @PUT("update")
    suspend fun update(@Body updateBody: UpdateBody): Nothing

    @POST("uploadProfilePic")
    suspend fun uploadProfilePic(@Body uploadProfilePicBody: UploadProfilePicBody): UploadProfilePicResponse

    @GET("getuser")
    suspend fun user(@Query("id") id: Int): User
}