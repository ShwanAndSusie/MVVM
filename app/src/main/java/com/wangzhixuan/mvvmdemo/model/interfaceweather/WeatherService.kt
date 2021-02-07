package com.wangzhixuan.mvvmdemo.model.interfaceweather

import com.wangzhixuan.mvvmdemo.model.data.WeatherInfoData
import io.reactivex.Single
import retrofit2.http.GET

/**
 *
 *
 * @author WangZhixuan 50536
 * @date 2020-02-28
 */
interface WeatherService {
    @GET(("/data/sk/101190408.html"))
    fun getWeatherInfo(): Single<WeatherInfoData>
}