package com.example.firstclassbnccacademy.domain

import io.reactivex.rxjava3.core.Observable

interface ProvinceRepository {

    fun getAllIndonesiaProvinceData(): Observable<List<ProvinceDataModel>>

}