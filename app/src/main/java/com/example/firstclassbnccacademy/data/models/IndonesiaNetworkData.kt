package com.example.firstclassbnccacademy.data.models

import com.google.gson.annotations.SerializedName

data class IndonesiaNetworkData(
    @SerializedName("name")
    val name: String,
    @SerializedName("positif")
    val positive: String,
    @SerializedName("sembuh")
    val recovered: String,
    @SerializedName("meninggal")
    val deaths: String
)