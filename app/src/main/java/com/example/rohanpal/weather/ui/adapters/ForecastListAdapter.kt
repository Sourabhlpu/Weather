package com.example.rohanpal.weather.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.example.rohanpal.weather.domain.model.ForecastList

/**
 * Created by rohanpal on 8/18/2017.
 */
class ForecastListAdapter(val weekForecast: ForecastList) :
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {

        with(weekForecast.dailyForecast[position])
        {
            holder?.textView?.text = "$date - $description - $high/$low"
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {

        return ViewHolder(TextView(parent?.context))
    }

    override fun getItemCount(): Int = weekForecast.dailyForecast.size

    class ViewHolder(val textView : TextView) : RecyclerView.ViewHolder(textView)

}
