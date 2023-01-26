package com.android.example.fleetioassessment.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Vehicle(
    val id: Long,
    val name: String?,
    val thumbnailUrl: String? = null,
    val make: String? = null,
    val model: String? = null,
    val largeImageUrl: String? = null,
    val status: String? = null,
    val meter1Name: String?,
    val meter1Value: String?,
    val meter1Units: String?,
    val meter2Exists: Boolean?,
    val meter2Name: String? = null,
    val meter2Value: String? = null,
    val meter2Units: String? = null,
    val driver: Driver? = null,
    val vin: String? = null,
    val licensePlate: String? = null,
    val ownership: String? = null
): Parcelable
