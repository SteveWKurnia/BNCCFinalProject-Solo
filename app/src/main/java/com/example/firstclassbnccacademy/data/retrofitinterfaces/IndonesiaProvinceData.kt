package com.example.firstclassbnccacademy.data.retrofitinterfaces

import com.example.firstclassbnccacademy.data.models.ProvinceNetworkAttribute
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface IndonesiaProvinceData {

    @GET("/indonesia/provinsi")
    fun getAllProvinceData(): Observable<List<ProvinceNetworkAttribute>>

}