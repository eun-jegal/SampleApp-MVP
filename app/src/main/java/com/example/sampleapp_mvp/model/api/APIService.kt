package com.example.sampleapp_mvp.model.api

import com.example.sampleapp_mvp.model.model.Users
import retrofit2.http.GET

interface APIService {
    @GET("users")
    suspend fun getUsers(): Users
}