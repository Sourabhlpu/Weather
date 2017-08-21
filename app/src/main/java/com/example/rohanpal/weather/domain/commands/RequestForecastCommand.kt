package com.example.rohanpal.weather.domain.commands

import com.example.rohanpal.weather.data.ForecastRequest
import com.example.rohanpal.weather.domain.mappers.ForecastDataMapper
import com.example.rohanpal.weather.domain.model.ForecastList

/**
 * Created by rohanpal on 8/19/2017.
 */

class RequestForecastCommand(val zipCode: String) : Command<ForecastList>
{
    override fun execute(): ForecastList {

        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}
