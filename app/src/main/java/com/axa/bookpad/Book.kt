package com.axa.bookpad

data class Book (
    var title: String = "",
    var series: String = "",
    var published_by: String = "",
    var release_date: String = "",
    var genre: String = "",
    var pages: Int = 0,
    var isbn: String = "",
    var sinopsis: String = "",
    var photo: Int = 0
)