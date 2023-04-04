package com.example.sampleapp_mvp.model.repository

import com.example.sampleapp_mvp.model.model.Users

interface Repository {
    suspend fun getUsers(): Users
}