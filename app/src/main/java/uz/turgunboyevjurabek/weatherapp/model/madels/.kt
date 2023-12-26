package uz.turgunboyevjurabek.weatherapp.model.madels


import com.google.gson.annotations.SerializedName

data class Kt(
    @SerializedName("clouds")
    val clouds: uz.turgunboyevjurabek.weatherapp.model.madels.Clouds,
    @SerializedName("dt")
    val dt: Int,
    @SerializedName("dt_txt")
    val dtTxt: String,
    @SerializedName("main")
    val main: uz.turgunboyevjurabek.weatherapp.model.madels.Main,
    @SerializedName("pop")
    val pop: Double,
    @SerializedName("snow")
    val snow: uz.turgunboyevjurabek.weatherapp.model.madels.Snow,
    @SerializedName("sys")
    val sys: uz.turgunboyevjurabek.weatherapp.model.madels.Sys,
    @SerializedName("visibility")
    val visibility: Int,
    @SerializedName("weather")
    val weather: List<uz.turgunboyevjurabek.weatherapp.model.madels.Weather>,
    @SerializedName("wind")
    val wind: uz.turgunboyevjurabek.weatherapp.model.madels.Wind
)