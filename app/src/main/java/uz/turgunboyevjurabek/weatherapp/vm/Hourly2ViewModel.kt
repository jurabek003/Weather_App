package uz.turgunboyevjurabek.weatherapp.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import uz.turgunboyevjurabek.weatherapp.model.madels.hourly2.ApiHourly2
import uz.turgunboyevjurabek.weatherapp.model.repo.AppRepository
import uz.turgunboyevjurabek.weatherapp.utils.Resource
import javax.inject.Inject

@HiltViewModel
class Hourly2ViewModel @Inject constructor(private val appRepository: AppRepository):ViewModel() {
    private val getApiLiveData=MutableLiveData<Resource<ApiHourly2>>()
    fun getApi(lat:Double,lon:Double):MutableLiveData<Resource<ApiHourly2>>{
        viewModelScope.launch {
            getApiLiveData.postValue(Resource.loading("Loading at Hourly2"))
            try {
                coroutineScope {
                    val data=async {
                        appRepository.getHourly2Weather(lat, lon)
                    }.await()
                    getApiLiveData.postValue(Resource.success(data))
                }
            }catch (e:Exception){
                getApiLiveData.postValue(Resource.error(e.message))
            }

        }
        return getApiLiveData
    }

}