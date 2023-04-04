package com.example.sampleapp_mvp.presenter

import com.example.sampleapp_mvp.Contract
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class Presenter(
    private val model: Contract.Model
) : Contract.Presenter, CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext = job

    private lateinit var view: Contract.View

    override fun setView(view: Contract.View) {
        this.view = view
    }

    override fun onClickUpdateButton() {
        launch(Dispatchers.Main) {
            view.hideUpdateButton()
            view.showProgressBar()
            try {
                val users = withContext(Dispatchers.IO) {
                    model.getUsers()
                }
                if (users.isNotEmpty()) {
                    view.run {
                        hideProgressBar()
                        updateUserList(users)
                    }
                }
            } catch (e: Exception) {
                view.run {
                    hideProgressBar()
                    showErrorMessage()
                }
            }
        }
    }

    override fun onClearJob() {
        job.cancel()
    }
}