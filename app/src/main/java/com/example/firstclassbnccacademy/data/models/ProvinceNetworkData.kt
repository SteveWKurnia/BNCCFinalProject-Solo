package com.example.firstclassbnccacademy.data.models

import com.google.gson.annotations.SerializedName

data class ProvinceNetworkData(
    @SerializedName("Provinsi")
    val province: String,
    @SerializedName("Kasus_Posi")
    val positive: Int,
    @SerializedName("Kasus_Semb")
    val recovered: Int,
    @SerializedName("Kasus_Meni")
    val death: Int
)