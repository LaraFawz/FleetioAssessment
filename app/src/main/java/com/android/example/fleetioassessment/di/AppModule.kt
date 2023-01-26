package com.android.example.fleetioassessment.di

import android.app.Application
import com.android.example.fleetioassessment.FleetioApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule constructor(private val application: FleetioApplication) {
    @Provides
    @Singleton
    fun getApplication(): Application {
        return application
    }
}