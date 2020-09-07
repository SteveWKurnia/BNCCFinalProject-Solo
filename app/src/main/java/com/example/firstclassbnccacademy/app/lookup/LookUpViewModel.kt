package com.example.firstclassbnccacademy.app.lookup

import android.content.Context
import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firstclassbnccacademy.domain.ProvinceDataModel
import com.example.firstclassbnccacademy.domain.usecase.GetIndonesiaProvinceAllCases
import dagger.hilt.android.qualifiers.ApplicationContext
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class LookUpViewModel @ViewModelInject constructor(
    @ApplicationContext private val context: Context,
    private val getIndonesiaProvinceAllCases: GetIndonesiaProvinceAllCases
) : ViewModel() {

    private val _provinceData: MutableLiveData<List<ProvinceData>> by lazy {
        MutableLiveData<List<ProvinceData>>()
    }

    val provinceData: LiveData<List<ProvinceData>>
            get() = _provinceData

    fun getAllProvinceData() {
        getIndonesiaProvinceAllCases.execute()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribeWith(object: DisposableObserver<List<ProvinceDataModel>>() {
                override fun onComplete() {
                    //no implementation
                }

                override fun onNext(provinceDataModel: List<ProvinceDataModel>?) {
                    _provinceData.postValue(provinceDataModel?.map {
                        ProvinceData(it.name, it.positiveCase, it.recoveredCase, it.deathCase)
                    })
                }

                override fun onError(e: Throwable?) {
                    Log.e("OnNetworkError", e?.message.toString())
                }
            })
    }

}