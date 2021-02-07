package com.wangzhixuan.mvvmdemo.viewmodel

import androidx.databinding.ObservableField
import com.wangzhixuan.mvvmdemo.model.data.WeatherInfoData
import com.wangzhixuan.mvvmdemo.model.interfaceweather.WeatherService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 *
 *
 * @author WangZhixuan 50536
 * @date 2020-02-28
 */
class WeatherViewModel(val remote: WeatherService) {
    val weatherinfo = ObservableField<String>()

    fun loadWeather(){
        remote.getWeatherInfo()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({t: WeatherInfoData->
                weatherinfo.set(t.let { it.weatherinfo.toString() })

            },{t: Throwable->
                weatherinfo.set(t.message?: "error")
            })
    }
}