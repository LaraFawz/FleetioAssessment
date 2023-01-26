package com.android.example.fleetioassessment.util

import com.android.example.fleetioassessment.data.Vehicle

class FleetListener(val clickListener: (fleet: Vehicle) -> Unit) {
    fun onClick(fleet: Vehicle?) = clickListener(fleet!!)
}