package uz.turgunboyevjurabek.weatherapp.madels.current


import com.google.gson.annotations.SerializedName

data class Sys(

    val country: String,

    val id: Int,

    val sunrise: Int,

    val sunset: Int,

    val type: Int
)