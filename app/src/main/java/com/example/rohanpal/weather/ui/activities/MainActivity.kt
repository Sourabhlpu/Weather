package com.example.rohanpal.weather

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.rohanpal.weather.data.Request
import com.example.rohanpal.weather.ui.adapters.ForecastListAdapter
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    private val items = listOf(
            "Today, May 17 - Clear - 17°C / 15°C",
            "Tomorrow - Cloudy - 19°C / 15°C",
            "Thursday - Rainy- 30°C / 11°C",
            "Friday - Thunderstorms - 21°C / 9°C",
            "Saturday - Thunderstorms - 16°C / 7°C",
            "Sunday - Rainy - 16°C / 8°C",
            "Monday - Partly Cloudy - 15°C / 10°C",
            "Tue, May 24 - Meatballs - 16°C / 18°C",
            "Wed, May 25 - Cloudy - 19°C / 15°C",
            "Thu, May 26 - Stormy - 30°C / 11°C",
            "Fri, May 27 - Hurricane - 21°C / 9°C",
            "Sat, May 28 - Meteors - 16°C / 7°C",
            "Sun, May 29 - Apocalypse - 16°C / 8°C",
            "Mon, May 30 - Post Apocalypse - 15°C / 10°C"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val forecastList : RecyclerView = find(R.id.forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)
        forecastList.adapter = ForecastListAdapter(items)

        val url = "http://api.openweathermap.org/data/2.5/forecast/daily?" +
                "APPID=15646a06818f61f7b8d7823ca833e1ce&q=94043&mode=json&units=metric&cnt=7"

        doAsync()
        {
            Request(url).run()
            uiThread { longToast("Request Performed") }

        }

    }
}
