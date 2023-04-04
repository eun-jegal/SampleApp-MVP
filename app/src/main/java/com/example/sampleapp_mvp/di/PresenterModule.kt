package com.example.sampleapp_mvp.di

import com.example.sampleapp_mvp.presenter.Presenter
import com.example.sampleapp_mvp.Contract
import com.example.sampleapp_mvp.model.MainModel
import com.example.sampleapp_mvp.model.api.APIService
import com.example.sampleapp_mvp.model.repository.Repository
import com.example.sampleapp_mvp.model.repository.RepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresenterModule {
    @Singleton
    @Provides
    fun providePresenter(model: Contract.Model): Contract.Presenter {
        return Presenter(model)
    }

    @Singleton
    @Provides
    fun provideMainModel(repository: Repository): Contract.Model {
        return MainModel(repository)
    }

    @Singleton
    @Provides
    fun provideRepository(apiService: APIService): Repository {
        return RepositoryImpl(apiService)
    }
}