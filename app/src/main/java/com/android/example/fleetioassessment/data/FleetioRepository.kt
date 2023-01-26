package com.android.example.fleetioassessment.data

import androidx.lifecycle.LiveData
import androidx.paging.PagingData

interface FleetioRepository {
    suspend fun getFleetList(): LiveData<PagingData<Vehicle>>
}