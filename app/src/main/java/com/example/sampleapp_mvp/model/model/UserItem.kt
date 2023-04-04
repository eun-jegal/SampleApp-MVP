package com.example.sampleapp_mvp.model.model


import com.google.gson.annotations.SerializedName

data class UserItem(
    @SerializedName("avatar")
    val avatar: String,
    @SerializedName("device_Token")
    val deviceToken: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("userId")
    val userId: String,
    @SerializedName("userToken")
    val userToken: String
)