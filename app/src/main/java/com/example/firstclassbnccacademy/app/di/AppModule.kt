package com.example.firstclassbnccacademy.app.di

import com.example.firstclassbnccacademy.data.ProvinceEntityRepository
import com.example.firstclassbnccacademy.data.repository.IndonesiaEntityRepository
import com.example.firstclassbnccacademy.domain.IndonesiaRepository
import com.example.firstclassbnccacademy.domain.ProvinceRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideIndonesiaRepository(indonesiaEntityRepository: IndonesiaEntityRepository): IndonesiaRepository
            = indonesiaEntityRepository

    @Provides
    @Singleton
    fun provideProvinceRepository(provinceEntityRepository: ProvinceEntityRepository): ProvinceRepository
            = provinceEntityRepository

}