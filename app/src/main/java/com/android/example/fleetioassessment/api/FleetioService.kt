package com.android.example.fleetioassessment.api


import com.android.example.fleetioassessment.api.model.VehicleResponse
import com.android.example.fleetioassessment.util.Constants.ACCOUNT_TOKEN
import com.android.example.fleetioassessment.util.Constants.AUTHORIZATION
import kotlinx.serialization.json.Json
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface FleetioService {
    companion object {
        const val FIRST_PAGE = 1
        const val VEHICLES_PER_PAGE = 50
    }
    /*
    * Returns a list of Vehicle.
    */
    @Headers(
        "Authorization: $AUTHORIZATION",
        "Account-Token: $ACCOUNT_TOKEN"
    )
    @GET("api/v1/vehicles")
    suspend fun getVehicleList(@Query("page") page: Int = FIRST_PAGE): List<VehicleResponse>

}