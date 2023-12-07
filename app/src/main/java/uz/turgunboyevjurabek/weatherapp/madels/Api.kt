package uz.turgunboyevjurabek.weatherapp.madels


import com.google.gson.annotations.SerializedName

data class Api(
    @SerializedName("cnt")
    val cnt: Int,
    @SerializedName("cod")
    val cod: String,
    @SerializedName("list")
    val list: List<Main>,
    @SerializedName("message")
    val message: Int
)