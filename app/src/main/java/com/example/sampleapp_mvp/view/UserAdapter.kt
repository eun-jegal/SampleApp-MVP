package com.example.sampleapp_mvp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sampleapp_mvp.model.model.UserItem
import com.example.sampleapp_mvp.databinding.ListItemBinding

class UserAdapter(
    private val users: ArrayList<UserItem>
): RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }

    fun addData(list: List<UserItem>) {
        users.clear()
        users.addAll(list)
        notifyDataSetChanged()
    }

    inner class UserViewHolder(
        private val binding: ListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(userItem: UserItem) {
            binding.apply {
                textName.text = userItem.name
                textEmail.text = userItem.email
                Glide.with(imageAvatar.context)
                    .load(userItem.avatar)
                    .centerCrop()
                    .into(imageAvatar)
            }
        }
    }
}