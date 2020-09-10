package com.example.firstclassbnccacademy.domain

import io.reactivex.rxjava3.core.Observable

interface HotlineRepository {

    fun getHotlineRepository(): Observable<List<HotlineDataModel>>

}