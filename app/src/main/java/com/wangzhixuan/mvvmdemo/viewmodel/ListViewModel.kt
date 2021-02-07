package com.wangzhixuan.mvvmdemo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.wangzhixuan.mvvmdemo.model.data.MailType

import java.util.ArrayList

/**
 * @author WangZhixuan 50536
 * @date 2020-11-30
 */
class ListViewModel : ViewModel() {
    private var mailTypes: MutableLiveData<ArrayList<MailType>>? = null

    fun getMailTypes(): MutableLiveData<ArrayList<MailType>> {
        if (mailTypes == null) {
            mailTypes = MutableLiveData()
            mailTypes!!.setValue(ArrayList())
        }
        return mailTypes as MutableLiveData<ArrayList<MailType>>
    }

    fun getFalseData() {
        val mailTypeList = ArrayList<MailType>()
        for (index in 0..10) {
            val mailType = MailType()
            mailType.text = "邮箱=$index"
            mailTypeList.add(mailType)
        }
        mailTypes?.value?.addAll(mailTypeList)
    }
}
