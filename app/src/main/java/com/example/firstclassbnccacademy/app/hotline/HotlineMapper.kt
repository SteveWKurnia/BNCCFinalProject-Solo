package com.example.firstclassbnccacademy.app.hotline

import com.example.firstclassbnccacademy.domain.HotlineDataModel
import javax.inject.Inject

class HotlineMapper @Inject constructor() {

    fun map(hotlineNetworkData: List<HotlineDataModel>): List<Hotline>? {
        val hotlineDatas = mutableListOf<Hotline>()
        hotlineNetworkData.map {
            hotlineDatas.add(mapToAppLayerModel(it))
        }
        return hotlineDatas
    }

    fun mapToAppLayerModel(hotlineNetworkData: HotlineDataModel) = Hotline(
        hotlineNetworkData.imgUrl,
        hotlineNetworkData.phoneNumber,
        hotlineNetworkData.description
    )

}