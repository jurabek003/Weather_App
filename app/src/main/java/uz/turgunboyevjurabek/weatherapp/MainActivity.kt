package uz.turgunboyevjurabek.weatherapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.turgunboyevjurabek.weatherapp.databinding.ActivityMainBinding
import uz.turgunboyevjurabek.weatherapp.madels.Primary
import uz.turgunboyevjurabek.weatherapp.madels.current.Current
import uz.turgunboyevjurabek.weatherapp.madels.current2.Current2
import uz.turgunboyevjurabek.weatherapp.network.ApiClient
import uz.turgunboyevjurabek.weatherapp.network.ApiClient.API_KEY
import uz.turgunboyevjurabek.weatherapp.network.ApiService


class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var apiSevis :ApiService

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val lat =41.2995
        val lon = 69.2401

         apiSevis=ApiClient.getApiService()

        apiSevis.getAll(lat,lon).enqueue(object :Callback<Current2>{
            override fun onResponse(
                call: Call<Current2>,
                response: Response<Current2>,
            ) {
                if (response.isSuccessful){
                    Toast.makeText(this@MainActivity, "ura ${response.body()}", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<Current2>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.message}  ishkalll", Toast.LENGTH_SHORT).show()
            }
        })
    }
}