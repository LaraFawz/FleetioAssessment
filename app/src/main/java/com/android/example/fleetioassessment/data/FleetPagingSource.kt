package com.android.example.fleetioassessment.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.android.example.fleetioassessment.api.FleetioService
import com.android.example.fleetioassessment.api.model.toDomainModel

class FleetPagingSource(
    private val service: FleetioService
) : PagingSource<Int, Vehicle>() {
    override fun getRefreshKey(state: PagingState<Int, Vehicle>): Int? {
        return state.anchorPosition?.let { position ->
            state.closestPageToPosition(position)?.prevKey?.plus(1) ?:
            state.closestPageToPosition(position)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Vehicle> {
        val position = params.key ?: FleetioService.FIRST_PAGE
        try {
            val vehicles = service.getVehicleList(position)
            val nextKey = when (vehicles.isEmpty()) {
                true -> null
                false -> {
                    position + (params.loadSize / FleetioService.VEHICLES_PER_PAGE)
                }
            }

            return LoadResult.Page(
                data = vehicles.map { it.toDomainModel() },
                nextKey = nextKey,
                prevKey = if (position == FleetioService.FIRST_PAGE) { null } else { position - 1 }
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }
}