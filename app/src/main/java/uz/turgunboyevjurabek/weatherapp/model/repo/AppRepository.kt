package uz.turgunboyevjurabek.weatherapp.model.repo

import uz.turgunboyevjurabek.weatherapp.model.network.ApiService
import javax.inject.Inject

class AppRepository @Inject constructor(val apiService: ApiService) {
    suspend fun getCurrentWeather(lat:Double,lon:Double)=apiService.getCurrentWeatherApi(lat, lon)
    suspend fun getHourlyWeather(lat: Double,lon: Double)=apiService.getAllHourly(lat, lon)


}