package com.josenaves.catalogbrowser

data class Movie(
    val id: Long,
    val category: String,
    val title: String
) {
    override fun toString() = title
}