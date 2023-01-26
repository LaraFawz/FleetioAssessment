package com.android.example.fleetioassessment.di

import android.app.Application
import com.android.example.fleetioassessment.FleetioApplication
import com.android.example.fleetioassessment.ui.main.MainFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class, NetworkModule::class])
interface AppComponent {

//    interface Builder {
//        @BindsInstance
//        fun application(application: Application): Builder
//
//        fun build(): AppComponent
//    }

    @Component.Builder
    interface Builder {
        fun appModule(module: AppModule): Builder
        fun build(): AppComponent
    }

    fun inject(fleetioApp: FleetioApplication)
    fun inject(mainFragment: MainFragment)
}