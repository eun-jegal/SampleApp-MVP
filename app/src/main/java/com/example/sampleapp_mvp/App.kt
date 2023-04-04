package com.example.sampleapp_mvp

import android.app.Application
import com.example.sampleapp_mvp.di.AppComponent
import com.example.sampleapp_mvp.di.DaggerAppComponent

class App: Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}