package com.josenaves.catalogbrowser

data class Movie(
    val id: Long,
    val category: String,
    val title: String,
    val description: String,
    val bgImageUrl: String,
    val cardImageUrl: String,
    val videoUrl: String,
    val studio: String
)