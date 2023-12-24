package uz.turgunboyevjurabek.weatherapp.madels.current


import com.google.gson.annotations.SerializedName

data class Main(
    val feelsLike: Double,
    val grndLevel: Int,
    val humidity: Int,
    val pressure: Int,
    val seaLevel: Int,
    val temp: Double,
    val tempMax: Double,
    val tempMin: Double
)