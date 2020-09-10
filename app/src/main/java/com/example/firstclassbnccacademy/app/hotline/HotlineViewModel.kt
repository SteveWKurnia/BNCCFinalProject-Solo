package com.example.firstclassbnccacademy.app.hotline

import android.content.Context
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firstclassbnccacademy.data.retrofitinterfaces.HotlineData
import com.example.firstclassbnccacademy.domain.usecase.GetHotlineData
import dagger.hilt.android.qualifiers.ApplicationContext

class HotlineViewModel @ViewModelInject constructor(
    @ApplicationContext context: Context,
    private val getHotlineData: GetHotlineData,
    private val mapper: HotlineMapper
) : ViewModel() {

    private val _hotlineDatas: MutableLiveData<List<HotlineData>> = MutableLiveData()

    val hotlineDatas: LiveData<List<HotlineData>>
        get() = _hotlineDatas



}