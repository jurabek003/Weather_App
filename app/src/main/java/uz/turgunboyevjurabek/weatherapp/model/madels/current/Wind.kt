package uz.turgunboyevjurabek.weatherapp.model.madels.current


import com.google.gson.annotations.SerializedName

data class Wind(

    val deg: Int,

    val gust: Double,

    val speed: Double
)