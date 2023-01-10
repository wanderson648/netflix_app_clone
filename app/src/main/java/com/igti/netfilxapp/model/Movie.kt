package com.igti.netfilxapp.model

data class Movie(
    val id: Int,
    val coverURL: String,
    val title: String = "",
    val desc: String = "",
    val cast: String = "",
)
