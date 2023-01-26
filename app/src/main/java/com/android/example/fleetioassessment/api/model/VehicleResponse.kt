package com.android.example.fleetioassessment.api.model

import com.android.example.fleetioassessment.data.Vehicle
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VehicleResponse(
    val id: Long,
    @SerialName("meter_unit") val meter_unit: String? = null,
    val name: String?= null,
    @SerialName("secondary_meter") val meter2Exists: Boolean? = null,
    @SerialName("vehicle_status_name") val status: String? = null,
    @SerialName("meter_name") val meter_name: String? = null,
    @SerialName("secondary_meter_unit") val secondary_meter_unit: String? = null,
    @SerialName("current_meter_value") val current_meter_value: Float? = null,
    @SerialName("secondary_meter_value") val secondary_meter_value: Float? = null,
    @SerialName("license_plate") val license_plate: String? = null,
    val make: String? = null,
    val model: String? = null,
    val vin: String? = null,
    @SerialName("default_image_url") val default_image_url: String? = null,
    @SerialName("default_image_url_small") val imageUrlSmall: String? = null,
    @SerialName("default_image_url_medium") val imageUrlMedium: String? = null,
    @SerialName("default_image_url_large") val imageUrlLarge: String? = null,
    val driver: FleetDriver? = null,
    val ownership: String? = null
)

fun VehicleResponse.toDomainModel(): Vehicle {
    return Vehicle(
        id = id,
        name = name,
        thumbnailUrl = default_image_url,
        make = make,
        model = model,
        largeImageUrl = default_image_url,
        status = status,
        meter1Name = meter_name,
        meter1Value = current_meter_value.toString(),
        meter1Units = meter_unit,
        meter2Exists = meter2Exists,
        meter2Name = secondary_meter_unit,
        meter2Value = secondary_meter_value?.toString(),
        driver = driver?.toDomainModel(),
        vin = vin,
        licensePlate = license_plate,
        ownership = ownership
    )
}