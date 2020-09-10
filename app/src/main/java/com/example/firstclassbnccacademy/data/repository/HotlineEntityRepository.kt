package com.example.firstclassbnccacademy.data.repository

import com.example.firstclassbnccacademy.data.RetrofitInstance
import com.example.firstclassbnccacademy.data.mapper.HotlineNetworkMapper
import com.example.firstclassbnccacademy.data.retrofitinterfaces.HotlineData
import com.example.firstclassbnccacademy.domain.HotlineDataModel
import com.example.firstclassbnccacademy.domain.HotlineRepository
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class HotlineEntityRepository @Inject constructor(
    private val hotlineMapper: HotlineNetworkMapper
) : HotlineRepository {

    override fun getHotlineRepository(): Observable<List<HotlineDataModel>> =
        RetrofitInstance.retrofit.create(HotlineData::class.java).getHotlineData()
            .map {
                hotlineMapper.map(it)
            }

}