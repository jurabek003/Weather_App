package uz.turgunboyevjurabek.weatherapp.model.madels.hourly2


import com.google.gson.annotations.SerializedName

data class Coord(
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lon")
    val lon: Double
)