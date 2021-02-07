package com.wangzhixuan.mvvmdemo.view.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.wangzhixuan.mvvmdemo.R
import com.wangzhixuan.mvvmdemo.base.BaseFragment
import com.wangzhixuan.mvvmdemo.view.MyObserver
import com.wangzhixuan.mvvmdemo.viewmodel.BaseViewModel
import kotlinx.android.synthetic.main.fisrt_fragment_layout.*

/**
 *
 *
 * @author WangZhixuan 50536
 * @date 2021-02-07
 */
class FirstFragment : BaseFragment() {

    private var baseObserver : MyObserver? = null
    private var baseViewModel : BaseViewModel? = null
    override fun initView(inflater: LayoutInflater, container: ViewGroup?): View {
        return inflater.inflate(R.layout.fisrt_fragment_layout,container,false)
    }

    override fun initData() {
    }

    override fun initListener() {
    }

    override fun initObserver(view: View?) {
        baseObserver = MyObserver()
        lifecycle.addObserver(baseObserver!!)
    }

    override fun initViewModel() {
        baseViewModel = ViewModelProviders.of(this).get(BaseViewModel::class.java)
        baseViewModel!!.getValue().observe(this, Observer {
            tv.text = it
        })
    }
}