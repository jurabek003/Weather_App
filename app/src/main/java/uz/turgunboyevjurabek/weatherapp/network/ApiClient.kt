package uz.turgunboyevjurabek.weatherapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    const val BASE_URL="https://api.openweathermap.org/data/2.5/"
    const val API_KEY="9c2d3c15fb31153647ff07edd0af4a70"
    const val WEATHER_UNIT = "metric"
    private fun getRetrofit2(): Retrofit
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