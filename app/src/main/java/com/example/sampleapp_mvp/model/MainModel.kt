package com.example.sampleapp_mvp.model

import com.example.sampleapp_mvp.Contract
import com.example.sampleapp_mvp.model.model.Users
import com.example.sampleapp_mvp.model.repository.Repository

class MainModel(
    private val repository: Repository
): Contract.Model {

    override suspend fun getUsers(): Users {
        return repository.getUsers()
    }
}