package com.android.example.fleetioassessment.api.model

import com.android.example.fleetioassessment.data.Driver
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FleetDriver(
    val id: Long? = null,
    @SerialName("first_name") val first_name: String? = null,
    @SerialName("last_name") val last_name: String? = null,
    @SerialName("full_name") val full_name: String? = null,
    @SerialName("default_image_url") val default_image_url: String? = null
//    @SerialName("first_name") val firstName: String? = null,
//    @SerialName("last_name") val lastName: String? = null,
//    @SerialName("full_name") val fullName: String? = null,
//    @SerialName("default_image_url") val imgUrl: String? = null
)

fun FleetDriver.toDomainModel(): Driver? {
    return if (this.id != null) {
        Driver(
            id = id,
            fullName = full_name ?: "",
            imgUrl = default_image_url
        )
    } else {
        null
    }
}