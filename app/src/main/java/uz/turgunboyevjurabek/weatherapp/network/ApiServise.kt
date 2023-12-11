package uz.turgunboyevjurabek.weatherapp.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import uz.turgunboyevjurabek.weatherapp.madels.Primary
import uz.turgunboyevjurabek.weatherapp.madels.current.Current
import uz.turgunboyevjurabek.weatherapp.network.ApiClient.API_KEY
import uz.turgunboyevjurabek.weatherapp.network.ApiClient.WEATHER_UNIT


interface ApiService {
    @GET("weather")
    fun getAll(@Query("lat") lat:String, @Query("lon") lon:String, @Query("appid") appid:String=API_KEY): Call<ArrayList<Primary>>

}