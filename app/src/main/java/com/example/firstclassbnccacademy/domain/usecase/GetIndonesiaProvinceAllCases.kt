package com.example.firstclassbnccacademy.domain.usecase

import com.example.firstclassbnccacademy.domain.ProvinceDataModel
import com.example.firstclassbnccacademy.domain.ProvinceRepository
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class GetIndonesiaProvinceAllCases @Inject constructor(
    private val provinceRepository: ProvinceRepository
) {
    fun execute(): Observable<List<ProvinceDataModel>> = provinceRepository.getAllIndonesiaProvinceData()
}