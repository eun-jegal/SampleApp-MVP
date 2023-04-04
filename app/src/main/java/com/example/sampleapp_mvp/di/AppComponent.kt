package com.example.sampleapp_mvp.di

import com.example.sampleapp_mvp.view.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [NetworkModule::class, PresenterModule::class]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}