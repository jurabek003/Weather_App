package uz.turgunboyevjurabek.weatherapp.network

import retrofit2.Call
import retrofit2.http.GET
import uz.turgunboyevjurabek.weatherapp.madels.Api

interface ApiService {
    @GET("forecast/")
    fun getAll():Call<ArrayList<Api>>
    
}