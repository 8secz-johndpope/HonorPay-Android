package com.freeworldone.honorpay.data.enums


enum class UserType(val type: Int) {
    DECEASED(-1),
    GHOST(0),
    UNCONFIRMED(1),
    CONFIRMED(2);

    companion object {
        fun fromInt(type: Int) = when(type){
            DECEASED.type -> DECEASED
            GHOST.type -> GHOST
            UNCONFIRMED.type -> UNCONFIRMED
            else -> CONFIRMED
        }
    }
}