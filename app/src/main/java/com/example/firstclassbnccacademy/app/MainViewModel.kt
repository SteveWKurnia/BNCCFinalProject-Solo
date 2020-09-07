package com.example.firstclassbnccacademy.app

import android.content.Context
import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firstclassbnccacademy.domain.GetIndonesiaPositiveCases
import com.example.firstclassbnccacademy.domain.GetIndonesiaTotalCases
import dagger.hilt.android.qualifiers.ApplicationContext
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.observers.DefaultObserver
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.Executors

class MainViewModel @ViewModelInject constructor(
    @ApplicationContext context: Context,
    private val getIndonesiaTotalCases: GetIndonesiaTotalCases,
    private val getIndonesiaPositiveCases: GetIndonesiaPositiveCases
) : ViewModel() {

    private val _totalCase: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    private val _positiveCase: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val positiveCases: LiveData<String>
        get() {
            return _positiveCase
        }

    val totalCase: LiveData<String>
        get() {
            return _totalCase
        }

    fun getIndonesiaTotalCases(){
        getIndonesiaTotalCases.execute()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : DisposableObserver<String>() {
                override fun onNext(t: String?) {
                    _totalCase.postValue(t.orEmpty())
                }

                override fun onComplete() {

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

                }

                override fun onError(e: Throwable?) {
                    Log.e("ErrorMessage", e.toString())
                }
            })
    }

}