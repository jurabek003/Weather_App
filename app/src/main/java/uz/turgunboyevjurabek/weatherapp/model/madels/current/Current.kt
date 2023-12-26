package uz.turgunboyevjurabek.weatherapp.model.madels.current


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
    val clouds: uz.turgunboyevjurabek.weatherapp.model.madels.current.Clouds,
    val cod: Int,
    val coord: uz.turgunboyevjurabek.weatherapp.model.madels.current.Coord,
    val dt: Int,
    val id: Int,
    val main: uz.turgunboyevjurabek.weatherapp.model.madels.current.Main,
    val name: String,
    //val rain: Rain,
    val sys: uz.turgunboyevjurabek.weatherapp.model.madels.current.Sys,
    val timezone: Int,
    val visibility: Int,
    val weather: List<uz.turgunboyevjurabek.weatherapp.model.madels.current.Weather>,
    val wind: uz.turgunboyevjurabek.weatherapp.model.madels.current.Wind

)