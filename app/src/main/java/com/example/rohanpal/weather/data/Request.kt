package com.example.rohanpal.weather.data

import android.util.Log
import java.net.URL

/**
 * Created by rohanpal on 8/19/2017.
 */

class Request(val url : String)
{
    fun run()
    {
        val forecastJsonStr =  URL(url).readText()
        Log.d(javaClass.simpleName,forecastJsonStr)
    }
}
