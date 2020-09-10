package com.example.firstclassbnccacademy.domain.usecase

import com.example.firstclassbnccacademy.domain.HotlineRepository
import javax.inject.Inject

class GetHotlineData @Inject constructor(
    private val hotlineRepository: HotlineRepository
) {

}