package com.example.sampleapp_mvp

import com.example.sampleapp_mvp.model.model.Users

interface Contract {
    interface Model {
        suspend fun getUsers(): Users
    }

    interface Presenter {
        fun onClickUpdateButton()
        fun setView(view: View)
        fun onClearJob()
    }

    interface View {
        fun hideUpdateButton()
        fun showProgressBar()
        fun hideProgressBar()
        fun updateUserList(users: Users)
        fun showErrorMessage()
    }
}