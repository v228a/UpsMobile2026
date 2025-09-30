package com.vovka.upsmobile.entity

data class TestItem(
    val id: String,
    val title: String,
    val course: String,
    val image: Int,
    val questions: List<Question>
)