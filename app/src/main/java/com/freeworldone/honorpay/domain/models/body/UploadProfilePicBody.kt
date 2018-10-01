package com.freeworldone.honorpay.domain.models.body

data class UploadProfilePicBody(
        val auth_token: String,
        val image_data: String)