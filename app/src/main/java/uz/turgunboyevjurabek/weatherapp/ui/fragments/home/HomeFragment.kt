package uz.turgunboyevjurabek.weatherapp.ui.fragments.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import uz.turgunboyevjurabek.weatherapp.databinding.FragmentHomeBinding
import uz.turgunboyevjurabek.weatherapp.utils.Status
import uz.turgunboyevjurabek.weatherapp.vm.current.CurrentWeatherViewModel


@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val binding by lazy {FragmentHomeBinding.inflate(layoutInflater)}
    private  val currentWeatherViewModel: CurrentWeatherViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getApiWorking()
    }

    private fun getApiWorking() {
        val lat =41.2995
        val lon = 69.2401

        currentWeatherViewModel.getApi(lat,lon).observe(requireActivity(), Observer {
            when(it.status){
                Status.LOADING -> {
                    binding.shimmerLayout.startShimmer()
                }
                Status.ERROR -> {
                    Log.d("essiz","${it.message}")
                    binding.shimmerLayout.stopShimmer()
                }
                Status.SUCCESS -> {
                    Toast.makeText(requireContext(), it.data.toString(), Toast.LENGTH_SHORT).show()
                    binding.shimmerLayout.hideShimmer()

                    binding.thtCountry.text=it.data?.sys?.country.toString()
                    val g=(it.data?.main?.temp_max!!-273.0).toInt()
                    binding.thtGradus.text="${g}℃"
                    binding.thtDescription.text=it.data.weather[0].description.toString()
                }
            }
        })
    }
}