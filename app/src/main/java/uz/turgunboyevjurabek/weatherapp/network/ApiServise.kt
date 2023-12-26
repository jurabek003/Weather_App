package uz.turgunboyevjurabek.weatherapp.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import uz.turgunboyevjurabek.weatherapp.model.madels.Primary
import uz.turgunboyevjurabek.weatherapp.model.madels.current.Current
import uz.turgunboyevjurabek.weatherapp.model.madels.current2.Current2
import uz.turgunboyevjurabek.weatherapp.network.ApiClient.API_KEY
import uz.turgunboyevjurabek.weatherapp.network.ApiClient.WEATHER_UNIT


interface ApiService {
    @GET("weather")
    fun getAll(
        @Query("lat") lat:Double,
        @Query("lon") lon:Double,
        @Query("appid") appid:String=API_KEY): Call<uz.turgunboyevjurabek.weatherapp.model.madels.current2.Current2>

}