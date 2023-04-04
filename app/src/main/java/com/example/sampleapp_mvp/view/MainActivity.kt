package com.example.sampleapp_mvp.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sampleapp_mvp.App
import com.example.sampleapp_mvp.Contract
import com.example.sampleapp_mvp.R
import com.example.sampleapp_mvp.model.model.Users
import com.example.sampleapp_mvp.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity(), Contract.View {

    @Inject
    lateinit var presenter: Contract.Presenter
    private lateinit var binding: ActivityMainBinding
    private val userAdapter = UserAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (applicationContext as App).appComponent.inject(this)
        presenter.setView(this)

        initLayout()
    }

    private fun initLayout() {
        binding.apply {
            recyclerView.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = userAdapter
            }
            btnUpdateData.setOnClickListener {
                presenter.onClickUpdateButton()
            }
        }
    }

    override fun hideUpdateButton() {
        binding.btnUpdateData.visibility = View.GONE
    }

    override fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        binding.progressBar.visibility = View.GONE
    }

    override fun updateUserList(users: Users) {
        binding.recyclerView.visibility = View.VISIBLE
        userAdapter.addData(users)
    }

    override fun showErrorMessage() {
        binding.errorMessage.apply {
            visibility = View.VISIBLE
            text = resources.getString(R.string.network_error_msg)
        }
    }

    override fun onStop() {
        super.onStop()
        presenter.onClearJob()
    }
}