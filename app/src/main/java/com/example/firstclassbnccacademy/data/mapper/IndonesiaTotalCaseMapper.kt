package com.example.firstclassbnccacademy.data.mapper

import com.example.firstclassbnccacademy.data.UtilityHelper.removeComma
import com.example.firstclassbnccacademy.data.models.IndonesiaNetworkData
import javax.inject.Inject

class IndonesiaTotalCaseMapper @Inject constructor() {

    fun map(indonesiaData: List<IndonesiaNetworkData>): String {
        val totalCases =    indonesiaData.get(0).deaths.removeComma().toInt() +
                            indonesiaData.get(0).positive.removeComma().toInt() +
                            indonesiaData.get(0).recovered.removeComma().toInt()
        return totalCases.toString()
    }
}