package uz.turgunboyevjurabek.weatherapp.madels


import com.google.gson.annotations.SerializedName

data class Snow(
    @SerializedName("3h")
    var h: Double
)