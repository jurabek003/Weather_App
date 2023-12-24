package uz.turgunboyevjurabek.weatherapp.madels.current


import com.google.gson.annotations.SerializedName

data class Current(
//    @SerializedName("base")
//    val base: String,
//    @SerializedName("clouds")
//    val clouds: Clouds?,  // Agar "clouds" ma'lumoti JSON faylda bo'lsa
//    @SerializedName("cod")
//    val cod: Int,
//    @SerializedName("coord")
//    val coord: Coord,
//    @SerializedName("dt")
//    val dt: Int,
//    @SerializedName("id")
//    val id: Int,
//    @SerializedName("main")
//    val main: Main,
//    @SerializedName("name")
//    val name: String,
////    @SerializedName("rain")
////    val rain: Rain?,  // Agar "rain" ma'lumoti JSON faylda bo'lsa
//    @SerializedName("sys")
//    val sys: Sys,
//    @SerializedName("timezone")
//    val timezone: Int,
//    @SerializedName("visibility")
//    val visibility: Int,
//    @SerializedName("weather")
//    val weather: List<Weather>,
//    @SerializedName("wind")
//    val wind: Wind
    val base: String,
    val clouds: Clouds,
    val cod: Int,
    val coord: Coord,
    val dt: Int,
    val id: Int,
    val main: Main,
    val name: String,
    //val rain: Rain,
    val sys: Sys,
    val timezone: Int,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind

)