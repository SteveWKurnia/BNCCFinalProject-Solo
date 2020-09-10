package com.example.firstclassbnccacademy.data.retrofitinterfaces

import com.example.firstclassbnccacademy.data.models.HotlineNetworkData
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface HotlineData {

    @GET("https://bncc-corona-versus.firebaseio.com/v1/hotlines.json")
    fun getHotlineData(): Observable<List<HotlineNetworkData>>

}