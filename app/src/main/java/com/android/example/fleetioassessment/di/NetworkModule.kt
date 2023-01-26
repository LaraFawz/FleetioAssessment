package com.android.example.fleetioassessment.di

import com.android.example.fleetioassessment.api.FleetioService
import com.android.example.fleetioassessment.util.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Provides Network communication related instances.
 */
@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideFleetioService(): FleetioService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
//            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(FleetioService::class.java)
    }
}