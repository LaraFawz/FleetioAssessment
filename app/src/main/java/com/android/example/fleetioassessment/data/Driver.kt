package com.android.example.fleetioassessment.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Driver(
    val id: Long,
    val fullName: String,
    val imgUrl: String? = null
): Parcelable