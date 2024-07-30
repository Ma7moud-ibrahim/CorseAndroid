package com.example.listview

import com.google.gson.annotations.SerializedName


//val ListOfGym = listOf<Gym>(
//    Gym(1,"Title1","Description1"),
//    Gym(2,"Title2","Description2"),
//    Gym(3,"Title3","Description3"),
//    Gym(4,"Title4","Description4"),
//    Gym(5,"Title5","Description5"),
//    Gym(6,"Title6","Description6"),
//)

data class Gym(
    val id: Int,
    @SerializedName("gym_name")
    val name: String,
    @SerializedName("gym_location")
    val place: String,
    @SerializedName("is_open")
    val isOpen :Boolean,
    var isFavourite: Boolean = false
)