package com.example.firstclassbnccacademy.app.hotline

import android.content.Context
import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firstclassbnccacademy.data.retrofitinterfaces.HotlineData
import com.example.firstclassbnccacademy.domain.HotlineDataModel
import com.example.firstclassbnccacademy.domain.usecase.GetHotlineData
import dagger.hilt.android.qualifiers.ApplicationContext
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class HotlineViewModel @ViewModelInject constructor(
    @ApplicationContext context: Context,
    private val getHotlineData: GetHotlineData,
    private val mapper: HotlineMapper
) : ViewModel() {

    private val _hotlineDatas: MutableLiveData<List<Hotline>> = MutableLiveData()

    val hotlineDatas: LiveData<List<Hotline>>
        get() = _hotlineDatas

    fun getHotlineDatas() {
        getHotlineData.execute()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribeWith(object : DisposableObserver<List<HotlineDataModel>>() {
                override fun onComplete() {
                    //no implementation
                }

                override fun onNext(hotlineDataModel: List<HotlineDataModel>?) {
                    _hotlineDatas.postValue(mapper.map(hotlineDataModel.orEmpty()).orEmpty())
                }

                override fun onError(e: Throwable?) {
                    Log.e("ERROR_MESSAGE_NETWORK", e?.message.toString())
                }
            })
    }


}