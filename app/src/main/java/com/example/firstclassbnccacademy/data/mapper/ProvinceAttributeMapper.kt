package com.example.firstclassbnccacademy.data.mapper

import com.example.firstclassbnccacademy.data.models.ProvinceNetworkAttribute
import com.example.firstclassbnccacademy.domain.ProvinceDataModel
import javax.inject.Inject

class ProvinceAttributeMapper @Inject constructor(){

    fun map(provinceNetworkAttribute: List<ProvinceNetworkAttribute>): List<ProvinceDataModel> {
        val provinceDataModels = mutableListOf<ProvinceDataModel>()

        for(i in provinceNetworkAttribute.indices) {
            provinceDataModels.add(mapAttribute(provinceNetworkAttribute.get(i)))
        }

        return provinceDataModels
    }

    private fun mapAttribute(provinceNetworkAttribute: ProvinceNetworkAttribute): ProvinceDataModel {
        val provinceDataModel = ProvinceDataModel("",0,0,0)
        provinceDataModel.apply {
            name = provinceNetworkAttribute.provinceData.province
            positiveCase = provinceNetworkAttribute.provinceData.positive
            recoveredCase = provinceNetworkAttribute.provinceData.recovered
            deathCase = provinceNetworkAttribute.provinceData.death
        }
        return provinceDataModel
    }

}