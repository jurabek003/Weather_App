package uz.turgunboyevjurabek.weatherapp.ui.fragments.home

import android.graphics.Color
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
import eightbitlab.com.blurview.RenderScriptBlur
import uz.turgunboyevjurabek.weatherapp.R
import uz.turgunboyevjurabek.weatherapp.adapter.HourlyRvAdapter
import uz.turgunboyevjurabek.weatherapp.databinding.FragmentHomeBinding
import uz.turgunboyevjurabek.weatherapp.databinding.ItemRvHourlyBinding
import uz.turgunboyevjurabek.weatherapp.model.madels.hourly.ApiHourly
import uz.turgunboyevjurabek.weatherapp.utils.Status
import uz.turgunboyevjurabek.weatherapp.vm.Hourly2ViewModel
import uz.turgunboyevjurabek.weatherapp.vm.current.CurrentWeatherViewModel
import uz.turgunboyevjurabek.weatherapp.vm.hourly.HourlyViewModel


@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val binding by lazy {FragmentHomeBinding.inflate(layoutInflater)}
    private  val currentWeatherViewModel: CurrentWeatherViewModel by viewModels()
    private val hourlyViewModel:HourlyViewModel by viewModels()
    private val hourly2ViewModel:Hourly2ViewModel  by viewModels()
    lateinit var hourlyRvAdapter: HourlyRvAdapter
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

        getCurrentApiWorking()
        getHourlyApiWorking()
        getHourly2ApiWorking()


    }

    private fun getHourly2ApiWorking() {
        val lat =40.5409
        val lon = 70.9483
        hourly2ViewModel.getApi(lat, lon).observe(requireActivity(), Observer {
            when(it.status){
                Status.LOADING -> {

                }
                Status.ERROR -> {
                    Toast.makeText(requireContext(), "ehh ${it.message}", Toast.LENGTH_SHORT).show()
                }
                Status.SUCCESS -> {
                    Toast.makeText(requireContext(), "uraaa ${it.data}", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun getCurrentApiWorking() {
        val lat =40.5409
        val lon = 70.9483
        /**
         * Current Api olib kelish
         */
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

    private fun getHourlyApiWorking(){
        val lat =40.5409
        val lon = 70.9483

        hourlyViewModel.getHourlyData(lat,lon).observe(requireActivity(), Observer {
            when(it.status){
                Status.LOADING -> {

                }
                Status.ERROR -> {
                    Toast.makeText(requireContext(), "mayli siqlma ${it.message}", Toast.LENGTH_SHORT).show()
                    Log.d("blaaa","${it.message}" )
                }
                Status.SUCCESS -> {


                    binding.blurView.setupWith(binding.mainLayout)
                        .setBlurRadius(7f)
                        .setBlurEnabled(true)
                        .setBlurAutoUpdate(true)
                    val itemRvHourlyBinding=ItemRvHourlyBinding.inflate(layoutInflater)
                    itemRvHourlyBinding.blurView3.setupWith(itemRvHourlyBinding.itemLayout)
                        .setBlurRadius(7f)
                        .setBlurEnabled(true)
                        .setBlurAutoUpdate(true)


                    hourlyRvAdapter= HourlyRvAdapter()
                    hourlyRvAdapter.updateData(it.data?.list!!)
                    binding.rvHourly.adapter=hourlyRvAdapter
                    hourlyRvAdapter.notifyDataSetChanged()



                }
            }
        })

    }
}