package uz.turgunboyevjurabek.weatherapp.model.madels


import com.google.gson.annotations.SerializedName

data class Primary(
    @SerializedName("city")
    var city: uz.turgunboyevjurabek.weatherapp.model.madels.City,
    @SerializedName("cnt")
    var cnt: Int,
    @SerializedName("cod")
    var cod: String,
    @SerializedName("list")
    var list: List<uz.turgunboyevjurabek.weatherapp.model.madels.Kt> = arrayListOf(),
    @SerializedName("message")
    var message: Int
)