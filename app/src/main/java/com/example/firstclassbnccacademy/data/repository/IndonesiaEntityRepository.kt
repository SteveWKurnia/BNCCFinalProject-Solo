package com.example.firstclassbnccacademy.data.repository

import com.example.firstclassbnccacademy.data.RetrofitInstance
import com.example.firstclassbnccacademy.data.mapper.IndonesiaTotalCaseMapper
import com.example.firstclassbnccacademy.data.models.IndonesiaNetworkData
import com.example.firstclassbnccacademy.data.retrofitinterfaces.IndonesiaData
import com.example.firstclassbnccacademy.domain.IndonesiaRepository
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class IndonesiaEntityRepository @Inject constructor(
    private val indonesiaTotalCaseMapper: IndonesiaTotalCaseMapper
): IndonesiaRepository {

    override fun getIndonesiaTotalCases(): Observable<String> {
        return RetrofitInstance.retrofit.create(IndonesiaData::class.java).getIndonesiaData().map {
            indonesiaTotalCaseMapper.map(it)
        }.onErrorReturn {
            indonesiaTotalCaseMapper.map((listOf(IndonesiaNetworkData("Indonesia","1000","450","200"))))
        }
    }

    override fun getIndonesiaPositiveCases(): Observable<String> {
        TODO("Not yet implemented")
    }

    override fun getIndonesiaRecoveredCases(): Observable<String> {
        TODO("Not yet implemented")
    }

    override fun getIndonesiaDeathCases(): Observable<String> {
        TODO("Not yet implemented")
    }
}