package com.example.sampleapp_mvp.model.repository

import com.example.sampleapp_mvp.model.api.APIService
import com.example.sampleapp_mvp.model.model.Users

class RepositoryImpl(
    private val apiService: APIService
): Repository {
    override suspend fun getUsers(): Users {
        return apiService.getUsers()
    }
}