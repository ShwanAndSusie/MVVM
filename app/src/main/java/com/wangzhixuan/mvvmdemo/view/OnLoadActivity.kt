package com.wangzhixuan.mvvmdemo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.wangzhixuan.mvvmdemo.R
import com.wangzhixuan.mvvmdemo.databinding.ActivityOnLoadBinding
import com.wangzhixuan.mvvmdemo.model.interfaceweather.WeatherService
import com.wangzhixuan.mvvmdemo.viewmodel.WeatherViewModel
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class OnLoadActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_on_load)
        var activityOnLoadBinding: ActivityOnLoadBinding = DataBindingUtil.setContentView(this,R.layout.activity_on_load)
        val remote = Retrofit.Builder()
            .baseUrl("http://www.weather.com.cn")
            .addCallAdapterFactory((RxJava2CallAdapterFactory.create()))
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(WeatherService::class.java)
        var mViewModelWea: WeatherViewModel = WeatherViewModel(remote)
        activityOnLoadBinding.remote = mViewModelWea

    }
}
