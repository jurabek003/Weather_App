package uz.turgunboyevjurabek.weatherapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    const val BASE_URL="https://openweathermap.org/api/"
    private fun getRetrofit2():Retrofit
    {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun getApiService():ApiService{
        return getRetrofit2().create(ApiService::class.java)
    }

}