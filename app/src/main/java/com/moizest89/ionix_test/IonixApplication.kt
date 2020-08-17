package com.moizest89.ionix_test

import android.app.Application
import com.moizest89.ionix_test.data.repository.SandboxRepository
import com.moizest89.ionix_test.data.services.ApiService
import com.moizest89.ionix_test.presentation.main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class IonixApplication : Application() {


    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@IonixApplication)
            modules( listOf( applicationModule ) )
        }
    }


    private val applicationModule = module {

        single { ApiService() }
        single { SandboxRepository( androidContext() , get() ) }
        //ViewModels
        viewModel { MainViewModel( get() ) }

    }
}