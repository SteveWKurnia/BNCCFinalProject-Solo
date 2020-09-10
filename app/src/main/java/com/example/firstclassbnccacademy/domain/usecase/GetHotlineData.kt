package com.example.firstclassbnccacademy.domain.usecase

import com.example.firstclassbnccacademy.domain.HotlineDataModel
import com.example.firstclassbnccacademy.domain.HotlineRepository
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class GetHotlineData @Inject constructor(
    private val hotlineRepository: HotlineRepository
) {
    fun execute(): Observable<List<HotlineDataModel>> = hotlineRepository.getHotlineRepository()
}