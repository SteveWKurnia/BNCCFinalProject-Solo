package com.example.firstclassbnccacademy.data.models

import com.google.gson.annotations.SerializedName

data class ProvinceNetworkAttribute (
    @SerializedName("attributes")
    val provinceData: ProvinceNetworkData
)