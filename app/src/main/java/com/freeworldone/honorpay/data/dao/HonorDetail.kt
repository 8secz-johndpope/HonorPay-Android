package com.freeworldone.honorpay.data.dao

class HonorDetail(
//        val id: Int,
        val user_from: Int,
        val user_to: Int,
        val message: String,
        val timestamp: Long,

        val from_first_name: String,
        val from_last_name: String,
        val from_nickname: String,
        val from_type: Int,
        val from_honors_received: Int,

        val to_first_name: String,
        val to_last_name: String,
        val to_nickname: String,
        val to_type: Int,
        val to_honors_received: Int)