package com.example.firstclassbnccacademy.data.retrofitinterfaces

import com.example.firstclassbnccacademy.data.models.IndonesiaNetworkData
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface IndonesiaData {

    @GET("/indonesia")
    fun getIndonesiaData(): Observable<List<IndonesiaNetworkData>>

}
