package com.freeworldone.honorpay.data.models

data class Honor(val id: Int,
                 val user_from: Int,
                 val user_to: Int,
                 val message: String, //1000 byte text
                 val timestamp: Long)