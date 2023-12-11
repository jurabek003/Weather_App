package uz.turgunboyevjurabek.weatherapp.madels.current


import com.google.gson.annotations.SerializedName

data class Clouds(
    @SerializedName("all")
    val all: Int
)