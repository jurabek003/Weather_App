package uz.turgunboyevjurabek.weatherapp.model.madels.hourly2


import com.google.gson.annotations.SerializedName

data class ApiHourly2(
    @SerializedName("city")
    val city: City,
    @SerializedName("cnt")
    val cnt: Int,
    @SerializedName("cod")
    val cod: String,
    @SerializedName("list")
    val list: List<Hourly2>,
    @SerializedName("message")
    val message: Double
)