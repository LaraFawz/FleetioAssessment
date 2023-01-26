package com.android.example.fleetioassessment.util

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.android.example.fleetioassessment.data.Vehicle


sealed class MainUiStatus {
    data class Success(val vehicles: LiveData<PagingData<Vehicle>>): MainUiStatus()
    data class Error(val errorMessage: String): MainUiStatus()
    object Loading: MainUiStatus()
}