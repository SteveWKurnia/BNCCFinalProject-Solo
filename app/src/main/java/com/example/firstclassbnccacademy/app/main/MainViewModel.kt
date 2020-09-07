package com.example.firstclassbnccacademy.app.main

import android.content.Context
import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firstclassbnccacademy.domain.usecase.GetIndonesiaDeathCases
import com.example.firstclassbnccacademy.domain.usecase.GetIndonesiaPositiveCases
import com.example.firstclassbnccacademy.domain.usecase.GetIndonesiaRecoveredCases
import com.example.firstclassbnccacademy.domain.usecase.GetIndonesiaTotalCases
import dagger.hilt.android.qualifiers.ApplicationContext
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel @ViewModelInject constructor(
    @ApplicationContext context: Context,
    private val getIndonesiaTotalCases: GetIndonesiaTotalCases,
    private val getIndonesiaPositiveCases: GetIndonesiaPositiveCases,
    private val getIndonesiaRecoveredCases: GetIndonesiaRecoveredCases,
    private val getIndonesiaDeathCases: GetIndonesiaDeathCases
) : ViewModel() {

    private val _totalCase: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    private val _positiveCase: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    private val _recoveredCase: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    private val _deathCases: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val deathCases: LiveData<String>
        get() = _deathCases

    val positiveCases: LiveData<String>
        get() = _positiveCase

    val recoveredCase: LiveData<String>
        get() = _recoveredCase

    val totalCase: LiveData<String>
        get() = _totalCase

    fun getIndonesiaTotalCases(){
        getIndonesiaTotalCases.execute()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : DisposableObserver<String>() {
                override fun onNext(t: String?) {
                    _totalCase.postValue(t.orEmpty())
                }

                override fun onComplete() {
                    //no implementation
                }

                override fun onError(e: Throwable?) {
                    Log.e("ErrorMessage", e.toString())
                }
            })
    }

    fun getIndonesiaPositiveCases(){
        getIndonesiaPositiveCases.execute()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : DisposableObserver<String>() {
                override fun onNext(t: String?) {
                    _positiveCase.postValue(t.orEmpty())
                }

                override fun onComplete() {
                    //no implementation
                }

                override fun onError(e: Throwable?) {
                    Log.e("ErrorMessage", e.toString())
                }
            })
    }

    fun getIndonesiaRecoveredCases(){
        getIndonesiaRecoveredCases.execute()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : DisposableObserver<String>() {
                override fun onNext(t: String?) {
                    _recoveredCase.postValue(t.orEmpty())
                }

                override fun onComplete() {
                    //no implementation
                }

                override fun onError(e: Throwable?) {
                    Log.e("ErrorMessage", e.toString())
                }
            })
    }

    fun getIndonesiaDeathCases() {
        getIndonesiaDeathCases.execute()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribeWith(object : DisposableObserver<String>() {
                override fun onComplete() {
                    //no implementation
                }

                override fun onNext(t: String?) {
                    _deathCases.postValue(t.orEmpty())
                }

                override fun onError(e: Throwable?) {
                    Log.e("ErrorMessage", e.toString())
                }
            })
    }

}