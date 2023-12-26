package uz.turgunboyevjurabek.weatherapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import androidx.core.content.ContextCompat
import dagger.hilt.android.AndroidEntryPoint
import uz.turgunboyevjurabek.weatherapp.databinding.ActivityMainBinding


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        statusBarEdit()


      /*  apiSevis.getAll(lat,lon).enqueue(object :Callback<uz.turgunboyevjurabek.weatherapp.model.madels.current2.Current2>{
            override fun onResponse(
                call: Call<uz.turgunboyevjurabek.weatherapp.model.madels.current2.Current2>,
                response: Response<uz.turgunboyevjurabek.weatherapp.model.madels.current2.Current2>,
            ) {
                if (response.isSuccessful){
                    Toast.makeText(this@MainActivity, "ura ${response.body()}", Toast.LENGTH_LONG).show()
                    Log.d("keldi", "onResponse: ${response.body()} ")
                }
            }

            override fun onFailure(call: Call<uz.turgunboyevjurabek.weatherapp.model.madels.current2.Current2>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.message}  ishkalll", Toast.LENGTH_SHORT).show()
            }
        })
       */
    }

    private fun statusBarEdit() {
        /**
         * StatusBarni  o'zgartirish
         */
        window.statusBarColor = ContextCompat.getColor(this, android.R.color.transparent)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

    }
}