package com.example.firstclassbnccacademy.domain.usecase

import com.example.firstclassbnccacademy.domain.IndonesiaRepository
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class GetIndonesiaTotalCases @Inject constructor(
    private val indonesiaRepository: IndonesiaRepository
) {

    fun execute(): Observable<String> {
        return indonesiaRepository.getIndonesiaTotalCases()
    }

}