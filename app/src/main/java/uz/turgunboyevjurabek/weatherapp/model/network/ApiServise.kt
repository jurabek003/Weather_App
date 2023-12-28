package uz.turgunboyevjurabek.weatherapp.model.network

import retrofit2.http.GET
import retrofit2.http.Query
import uz.turgunboyevjurabek.weatherapp.model.madels.current2.Current2
import uz.turgunboyevjurabek.weatherapp.model.madels.hourly.ApiHourly
import uz.turgunboyevjurabek.weatherapp.model.madels.hourly2.ApiHourly2
import uz.turgunboyevjurabek.weatherapp.utils.ConsUtils.API_KEY


interface ApiService {
    @GET("weather/")
    suspend fun getCurrentWeatherApi(
        @Query("lat") lat:Double,
        @Query("lon") lon:Double,
        @Query("appid") appid:String=API_KEY): Current2
    @GET("forecast?")
    suspend fun getAllHourly(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") appid: String=API_KEY):ApiHourly

    @GET("forecast/daily?")
    suspend fun getHourly2(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") appid: String= API_KEY): ApiHourly2

}