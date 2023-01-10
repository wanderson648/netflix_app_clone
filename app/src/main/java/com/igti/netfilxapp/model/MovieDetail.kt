package com.igti.netfilxapp.model

data class MovieDetail(
    val movie: Movie,
    val similars: List<Movie>
)
