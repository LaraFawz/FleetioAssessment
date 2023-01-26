package com.android.example.fleetioassessment

import android.app.Application
import com.android.example.fleetioassessment.di.AppComponent
import com.android.example.fleetioassessment.di.AppModule
import com.android.example.fleetioassessment.di.DaggerAppComponent

/**
 * The application class - an entry point into our app where we initialize Dagger.
 */
class FleetioApplication : Application() {
    companion object {
        private lateinit var appComponent: AppComponent

        fun getAppComponent(): AppComponent {
            return appComponent
        }
    }

    override fun onCreate() {
        super.onCreate()
        initDaggerAppComponent()
    }

    private fun initDaggerAppComponent(): AppComponent {
        appComponent =
            DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
        return appComponent
    }
}
