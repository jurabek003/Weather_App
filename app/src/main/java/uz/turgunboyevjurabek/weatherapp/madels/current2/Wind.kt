package uz.turgunboyevjurabek.weatherapp.madels.current2


import com.google.gson.annotations.SerializedName

data class Wind(
    val deg: Int,
    val gust: Double,
    val speed: Double
)