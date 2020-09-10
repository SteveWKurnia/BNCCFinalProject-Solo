package com.example.firstclassbnccacademy.app.hotline

import com.example.bnccfinalproject.Hotline
import com.example.firstclassbnccacademy.data.models.HotlineNetworkData
import javax.inject.Inject

class HotlineMapper @Inject constructor() {

    fun map(hotlineNetworkData: List<HotlineNetworkData>): List<Hotline> {
        val hotlineDatas = mutableListOf<Hotline>()
        hotlineNetworkData.map {
            hotlineDatas.add(mapToAppLayerModel(it))
        }
        return hotlineDatas
    }

    fun mapToAppLayerModel(hotlineNetworkData: HotlineNetworkData) = Hotline(
        hotlineNetworkData.img_icon,
        hotlineNetworkData.phone,
        hotlineNetworkData.name
    )

}