package uz.turgunboyevjurabek.weatherapp.madels.current2


import com.google.gson.annotations.SerializedName

data class Sys(
    val country: String,
    val sunrise: Int,
    val sunset: Int
)