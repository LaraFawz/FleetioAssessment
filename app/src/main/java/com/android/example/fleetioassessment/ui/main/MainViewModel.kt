package com.android.example.fleetioassessment.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.android.example.fleetioassessment.data.DefaultFleetRepository
import com.android.example.fleetioassessment.data.Vehicle
import javax.inject.Inject


class MainViewModel @Inject constructor(private val vehicleRepository: DefaultFleetRepository) : ViewModel() {

//    lateinit var uiStatus: MainUiStatus
//    var searchJob: Job? = null

    private val _fleetList = MutableLiveData<PagingData<Vehicle>>()

    suspend fun getFleetList(): LiveData<PagingData<Vehicle>> {
        val response = vehicleRepository.getFleetList().cachedIn(viewModelScope)
        _fleetList.value = response.value
        return response
    }

    private val _navigateToDetail = MutableLiveData<Vehicle>()
    val navigateToDetail: LiveData<Vehicle>
        get() = _navigateToDetail


//     fun performSearch() {
//        searchJob?.cancel()
//        searchJob = viewModelScope.launch {
//            uiStatus = MainUiStatus.Loading
//            uiStatus = try {
//                val response = getFleetList()
//                Log.e("MainFragment: ", "Response: + ${response.value}")
//                MainUiStatus.Success(response)
//            } catch (e: Exception) {
//                e.printStackTrace()
//                MainUiStatus.Error(e.localizedMessage ?: "")
//            }
//        }
//    }


    /**
     * After the navigation has taken place, make sure navigateToSelectedFleet is set to null
     */
    fun displayFleetDetailsComplete() {
        _navigateToDetail.value = null
    }

    /**
     * When the fleet item is clicked, set the [_navigateToDetail] [MutableLiveData]
     * @param vehicle The [Vehicle] that was clicked on.
     */
    fun onFleetClicked(fleet: Vehicle) {
        _navigateToDetail.value = fleet
    }
}