package com.wangzhixuan.mvvmdemo.viewmodel

import androidx.databinding.ObservableField

/**
 *
 *
 * @author WangZhixuan 50536
 * @date 2020-03-13
 */
class RecycleItemViewModel(var text:String) {
    val recycleText = ObservableField<String>("${text}")
}