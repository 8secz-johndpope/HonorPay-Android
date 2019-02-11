package com.freeworldone.honorpay.api.models.body

data class UploadProfilePicBody(
        val auth_token: String,
        val image_data: String)