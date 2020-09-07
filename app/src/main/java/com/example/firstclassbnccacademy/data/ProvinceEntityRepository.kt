package com.example.firstclassbnccacademy.data

import com.example.firstclassbnccacademy.data.mapper.ProvinceAttributeMapper
import com.example.firstclassbnccacademy.data.retrofitinterfaces.IndonesiaProvinceData
import com.example.firstclassbnccacademy.domain.ProvinceDataModel
import com.example.firstclassbnccacademy.domain.ProvinceRepository
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class ProvinceEntityRepository @Inject constructor(
    private val provinceAttributeMapper: ProvinceAttributeMapper
): ProvinceRepository {

    override fun getAllIndonesiaProvinceData(): Observable<List<ProvinceDataModel>> {
        return RetrofitInstance.retrofit.create(IndonesiaProvinceData::class.java).getAllProvinceData()
            .map {
                provinceAttributeMapper.map(it)
            }
    }

}