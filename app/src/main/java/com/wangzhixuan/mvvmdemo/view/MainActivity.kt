package com.wangzhixuan.mvvmdemo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.wangzhixuan.mvvmdemo.R
import com.wangzhixuan.mvvmdemo.databinding.MainActivityMenuBinding
import com.wangzhixuan.mvvmdemo.model.Onclick
import com.wangzhixuan.mvvmdemo.viewmodel.OnclickViewModel
import com.wangzhixuan.mvvmdemo.viewmodel.WeatherViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var mViewModelWea: WeatherViewModel

    private lateinit var mainBinding: MainActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val onclick = Onclick("50536",0)
        mainBinding = DataBindingUtil.setContentView(this,R.layout.main_activity_menu)
        var mViewModel = OnclickViewModel(onclick,applicationContext,this)
        mainBinding.onclick = mViewModel
        val observer = MyObserver()
        mainBinding.lifecycleOwner = this
        lifecycle.addObserver(observer)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
