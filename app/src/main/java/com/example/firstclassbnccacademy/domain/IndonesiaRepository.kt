package com.example.firstclassbnccacademy.domain

import io.reactivex.rxjava3.core.Observable

interface IndonesiaRepository {

    fun getIndonesiaTotalCases(): Observable<String>

    fun getIndonesiaPositiveCases(): Observable<String>

    fun getIndonesiaRecoveredCases(): Observable<String>

    fun getIndonesiaDeathCases(): Observable<String>

}