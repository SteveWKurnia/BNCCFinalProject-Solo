package com.example.firstclassbnccacademy.data.mapper

import com.example.firstclassbnccacademy.data.models.HotlineNetworkData
import com.example.firstclassbnccacademy.domain.HotlineDataModel
import javax.inject.Inject

class HotlineNetworkMapper @Inject constructor() {

    fun map(hotlineNetworkData: List<HotlineNetworkData>): List<HotlineDataModel> {
        val hotlineDataModel = mutableListOf<HotlineDataModel>()
        
        hotlineNetworkData.map { 
            hotlineDataModel.add(HotlineDataModel(
                it.img_icon,
                it.phone,
                it.name
            ))
        }
        
        return hotlineDataModel
    }

}