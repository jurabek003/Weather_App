package uz.turgunboyevjurabek.weatherapp.madels


import com.google.gson.annotations.SerializedName

data class Clouds(
    @SerializedName("all")
    var all: Int
)