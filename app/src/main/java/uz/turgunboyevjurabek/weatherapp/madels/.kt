package uz.turgunboyevjurabek.weatherapp.madels


import com.google.gson.annotations.SerializedName

data class Simple (
    @SerializedName("dt")
    val dt: Int,
    @SerializedName("main")
    val main: Main
)