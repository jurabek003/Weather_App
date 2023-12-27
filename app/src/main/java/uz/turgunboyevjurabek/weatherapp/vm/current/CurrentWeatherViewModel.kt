package uz.turgunboyevjurabek.weatherapp.vm.current

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.internal.wait
import uz.turgunboyevjurabek.weatherapp.model.madels.current2.Current2
import uz.turgunboyevjurabek.weatherapp.model.repo.AppRepository
import uz.turgunboyevjurabek.weatherapp.utils.Resource
import javax.inject.Inject

@HiltViewModel
class CurrentWeatherViewModel @Inject constructor(private val appRepository: AppRepository):ViewModel() {
    private val getApiLiveData=MutableLiveData<Resource<Current2>>()
    fun getApi(lat:Double,lon:Double):MutableLiveData<Resource<Current2>>{
        viewModelScope.launch {
            try {
                getApiLiveData.postValue(Resource.loading("loadin at currentWeather"))
                coroutineScope {
                    val response= withContext(Dispatchers.IO){
                        appRepository.getCurrentWeather(lat,lon)
                    }
                    getApiLiveData.postValue(Resource.success(response) as Resource<Current2>)
                }

            }catch (e:Exception){
                getApiLiveData.postValue(Resource.error("${e.message}"))
            }
        }
        return getApiLiveData
    }

}