package com.example.firstclassbnccacademy.data.models

import com.google.gson.annotations.SerializedName

data class HotlineNetworkData(
    @SerializedName("img_icon")
    val img_icon: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("phone")
    val phone: String
)