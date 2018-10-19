package com.github.ranaice.weatherapp.domain.commands

import com.github.ranaice.weatherapp.data.ForecastRequest
import com.github.ranaice.weatherapp.domain.mappers.ForecastDataMapper
import com.github.ranaice.weatherapp.domain.model.ForecastList

class RequestForecastCommand(private val zipCode: String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }

}