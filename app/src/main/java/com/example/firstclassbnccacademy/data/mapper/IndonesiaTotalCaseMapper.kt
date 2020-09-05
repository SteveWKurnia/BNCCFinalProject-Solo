package com.example.firstclassbnccacademy.data.mapper

import com.example.firstclassbnccacademy.data.models.IndonesiaNetworkData
import javax.inject.Inject

class IndonesiaTotalCaseMapper @Inject constructor() {

    fun map(indonesiaData: List<IndonesiaNetworkData>): String {
        val totalCases = indonesiaData.get(0).deaths.toInt() + indonesiaData.get(0).positive.toInt() + indonesiaData.get(0).recovered.toInt()
        return totalCases.toString()
    }

}