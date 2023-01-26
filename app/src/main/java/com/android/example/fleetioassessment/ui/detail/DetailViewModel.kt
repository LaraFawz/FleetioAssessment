package com.android.example.fleetioassessment.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.example.fleetioassessment.data.Vehicle

class DetailViewModel(vehicle: Vehicle): ViewModel() {

        private val _selectedFleet = MutableLiveData<Vehicle>()

        val selectedFleet: LiveData<Vehicle>
        get() = _selectedFleet

        init {
            _selectedFleet.value = vehicle
        }
}