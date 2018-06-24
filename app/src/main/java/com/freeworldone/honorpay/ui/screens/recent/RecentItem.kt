package com.freeworldone.honorpay.ui.screens.recent

data class RecentItem(
        val honoredName: String,
        val honoredBy: String,
        val message: String,
        val timeAgo: String,
        val honorTotal: Int,
        val imageUrl: String?)