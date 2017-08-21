package com.example.rohanpal.weather.domain.model

/**
 * Created by rohanpal on 8/19/2017.
 */

data class ForecastList(val city: String, val country: String, val dailyForecast: List<Forecast>)
data class Forecast(val date: String, val description: String, val high: Int, val low: Int)