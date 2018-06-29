package com.freeworldone.honorpay.ui.base.items

data class HonorItem(
        val honoredBy: String?,
        val honoredName: String,
        val honorTotal: Int,
        val imageUrl: String?,
        val isMessageExpanded: Boolean,
        val isReceived: Boolean,
        val message: String,
        val timeAgo: String)