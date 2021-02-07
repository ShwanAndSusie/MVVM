package com.wangzhixuan.mvvmdemo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 *
 *
 * @author WangZhixuan 50536
 * @date 2021-02-07
 */
class BaseViewModel : ViewModel(){
    private var mValue : MutableLiveData<String> = MutableLiveData()
    fun getOnline() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                //自己的网络请求
                mValue.postValue("请求结果")
            }
        }
    }

    fun getValue(): MutableLiveData<String> {
        return mValue
    }
}