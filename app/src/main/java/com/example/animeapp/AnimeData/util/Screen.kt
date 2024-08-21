package com.example.animeapp.AnimeData.util

sealed class Screen(val route:String){

    object Home:Screen("main")

    object Details:Screen("details")


}


