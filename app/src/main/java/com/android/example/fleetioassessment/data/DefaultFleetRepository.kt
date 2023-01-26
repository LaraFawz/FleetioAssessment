package com.android.example.fleetioassessment.data

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.android.example.fleetioassessment.api.FleetioService
import javax.inject.Inject

class DefaultFleetRepository @Inject constructor(private val service: FleetioService) : FleetioRepository {

    override suspend fun getFleetList(): LiveData<PagingData<Vehicle>> {
        return Pager(
            config = PagingConfig(
                pageSize = FleetioService.VEHICLES_PER_PAGE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { FleetPagingSource(service) }
        ).liveData
    }
}