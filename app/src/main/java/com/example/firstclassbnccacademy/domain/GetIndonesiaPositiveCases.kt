package com.example.firstclassbnccacademy.domain

import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class GetIndonesiaPositiveCases @Inject constructor(
    private val indonesiaRepository: IndonesiaRepository
) {
    fun execute(): Observable<String> = indonesiaRepository.getIndonesiaPositiveCases()
}