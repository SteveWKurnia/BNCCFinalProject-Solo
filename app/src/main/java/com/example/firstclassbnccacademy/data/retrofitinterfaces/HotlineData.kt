package com.example.firstclassbnccacademy.data.retrofitinterfaces

import retrofit2.http.GET

interface HotlineData {

    @GET("https://bncc-corona-versus.firebaseio.com/v1/hotlines.json")
    fun getHotlineData()

}