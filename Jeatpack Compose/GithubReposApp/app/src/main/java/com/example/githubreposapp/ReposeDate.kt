package com.example.githubreposapp


val ListOfRepost= listOf<ReposeDate>(

    ReposeDate("title","supTitle","description")
)
data class ReposeDate(
    val title: String,
    val supTitle: String,
    val description: String
)