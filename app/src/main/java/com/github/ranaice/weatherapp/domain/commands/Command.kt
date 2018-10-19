package com.github.ranaice.weatherapp.domain.commands

public interface Command<out T> {
    fun execute(): T
}