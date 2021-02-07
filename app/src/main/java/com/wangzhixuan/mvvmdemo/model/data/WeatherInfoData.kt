package com.wangzhixuan.mvvmdemo.model.data

/**
 *
 *
 * @author WangZhixuan 50536
 * @date 2020-02-28
 */
data class WeatherInfoData(
    val weatherinfo: Weatherinfo
)

data class Weatherinfo(
    val AP: String,
    val Radar: String,
    val SD: String,
    val WD: String,
    val WS: String,
    val WSE: String,
    val city: String,
    val cityid: String,
    val isRadar: String,
    val njd: String,
    val sm: String,
    val temp: String,
    val time: String
)