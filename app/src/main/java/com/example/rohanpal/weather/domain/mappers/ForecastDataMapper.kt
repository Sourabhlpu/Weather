package com.example.rohanpal.weather.domain.mappers

import com.example.rohanpal.weather.data.Forecast
import com.example.rohanpal.weather.data.ForecastResult
import com.example.rohanpal.weather.domain.model.ForecastList
import java.text.DateFormat
import java.util.*
import java.util.concurrent.TimeUnit
import com.example.rohanpal.weather.domain.model.Forecast as ModelForecast

/**
 * Created by rohanpal on 8/19/2017.
 */

class ForecastDataMapper
{
    fun convertFromDataModel(forecast: ForecastResult): ForecastList
    {
        return ForecastList(forecast.city.name, forecast.city.country,
                convertForecastListToDomain(forecast.list))
    }


    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast>
    {
        return list.mapIndexed { i, forecast ->
            val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(i.toLong())
            convertForecastItemToDomain(forecast.copy(dt = dt))
        }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast
    {
        return ModelForecast(convertDate(forecast.dt), forecast.weather[0].description,
                forecast.temp.max.toInt(), forecast.temp.min.toInt())
    }

    private fun convertDate(date: Long): String{
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date)
    }
}
