package uz.turgunboyevjurabek.weatherapp.vm.hourly

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.turgunboyevjurabek.weatherapp.model.madels.hourly.ApiHourly
import uz.turgunboyevjurabek.weatherapp.model.repo.AppRepository
import uz.turgunboyevjurabek.weatherapp.utils.Resource
import javax.inject.Inject

@HiltViewModel
class HourlyViewModel @Inject constructor(private val appRepository: AppRepository) :ViewModel(){
    private val getApiLiveData=MutableLiveData<Resource<ApiHourly>>()

}