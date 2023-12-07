package uz.turgunboyevjurabek.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.turgunboyevjurabek.weatherapp.databinding.ActivityMainBinding
import uz.turgunboyevjurabek.weatherapp.madels.Api
import uz.turgunboyevjurabek.weatherapp.network.ApiClient
import uz.turgunboyevjurabek.weatherapp.network.ApiService

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    lateinit var apiSevis:ApiService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

          apiSevis= ApiClient.getApiService()
                  apiSevis.getAll().enqueue(object : Callback<ArrayList<Api>> {
                      override fun onResponse(
                          call: Call<ArrayList<Api>>,
                          response: Response<ArrayList<Api>>,
                      ) {
                          val list=response.body()
                          Toast.makeText(this@MainActivity, "$list", Toast.LENGTH_SHORT).show()
                      }

                      override fun onFailure(call: Call<ArrayList<Api>>, t: Throwable) {
                          Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
                      }
                  })

    }
}