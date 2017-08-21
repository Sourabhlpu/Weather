package com.example.rohanpal.weather.domain.commands

/**
 * Created by rohanpal on 8/19/2017.
 */

interface Command<out T>
{
    fun execute(): T
}
