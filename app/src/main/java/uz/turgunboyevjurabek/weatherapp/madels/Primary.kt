package uz.turgunboyevjurabek.weatherapp.madels


import com.google.gson.annotations.SerializedName

data class Primary(
    @SerializedName("city")
    var city: City,
    @SerializedName("cnt")
    var cnt: Int,
    @SerializedName("cod")
    var cod: String,
    @SerializedName("list")
    var list: List<Kt> = arrayListOf(),
    @SerializedName("message")
    var message: Int
)