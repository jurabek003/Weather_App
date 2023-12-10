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
import uz.turgunboyevjurabek.weatherapp.network.ApiClient
import uz.turgunboyevjurabek.weatherapp.network.ApiService


class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var apiSevis :ApiService

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val lat ="41.2995"
        val lon = "69.2401"

          apiSevis=ApiClient.getApiService()
                  apiSevis.getAll(lat,lon).enqueue(@SuppressLint("SuspiciousIndentation")
                  object : Callback<ArrayList<Primary>> {
                      override fun onResponse(
                          call: Call<ArrayList<Primary>>,
                          response: Response<ArrayList<Primary>>,
                      ) {
                          if (response.isSuccessful){
                              val list=response.body()
                              Toast.makeText(this@MainActivity, "$list", Toast.LENGTH_SHORT).show()
                          }else{
                              Toast.makeText(this@MainActivity, "not success", Toast.LENGTH_SHORT).show()
                          }
                      }

                      override fun onFailure(call: Call<ArrayList<Primary>>, t: Throwable) {
                          Toast.makeText(this@MainActivity, "${t.message} ishkal", Toast.LENGTH_SHORT).show()
                          Log.d("ishkal",t.message.toString() )
                      }
                  })

    }
}