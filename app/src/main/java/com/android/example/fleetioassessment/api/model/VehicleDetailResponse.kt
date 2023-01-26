package com.android.example.fleetioassessment.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VehicleDetailResponse(
    val id: Long,
    val name: String,
    @SerialName("default_image_url") val imageUrl: String? = null,
    @SerialName("default_image_url_small") val imageUrlSmall: String? = null,
    @SerialName("default_image_url_medium") val imageUrlMedium: String? = null,
    @SerialName("default_image_url_large") val imageUrlLarge: String? = null,
    val make: String? = null,
    val model: String? = null,
    @SerialName("vehicle_status_name") val status: String,
    @SerialName("meter_name") val meter1Name: String,
    @SerialName("current_meter_value") val meter1Value: Double,
    @SerialName("meter_unit") val meter1Units: String,
    @SerialName("secondary_meter") val meter2Exists: Boolean,
    @SerialName("secondary_meter_name") val meter2Name: String? = null,
    @SerialName("secondary_meter_value") val meter2Value: Double? = null,
    @SerialName("secondary_meter_unit") val meter2Units: String? = null,
    val driver: FleetDriver? = null,
    val vin: String? = null,
    @SerialName("license_plate") val licensePlate: String? = null
)
