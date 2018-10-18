package com.github.ranaice.weatherapp.data

import java.util.*

data class Forecast(val date: Date,
                    val temperature: Float,
                    val details: String)