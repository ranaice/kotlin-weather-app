package com.github.ranaice.weatherapp.adapters

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.github.ranaice.weatherapp.R
import com.github.ranaice.weatherapp.domain.model.Forecast
import com.github.ranaice.weatherapp.domain.model.ForecastList
import com.github.ranaice.weatherapp.utils.ctx
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find

class ForecastListAdapter(private val weekForecast: ForecastList, private val itemClick: ForecastListAdapter.OnItemClickListener) :
    RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_forecast, parent, false)

        return ViewHolder(view, itemClick)
    }


    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weekForecast[position])
    }

    override fun getItemCount(): Int = weekForecast.size

    class ViewHolder(view: View, private val itemClick: OnItemClickListener) : RecyclerView.ViewHolder(view) {
        private val iconView = view.find<ImageView>(R.id.icon)
        private val dateView = view.find<TextView>(R.id.date)
        private val descriptionView = view.find<TextView>(R.id.description)
        private val maxTemperatureView = view.find<TextView>(R.id.maxTemperature)
        private val minTemperatureView = view.find<TextView>(R.id.minTemperature)

        fun bindForecast(forecast: Forecast) {

            with(forecast) {
                Picasso.get().load(iconUrl).into(iconView)
                dateView.text = date
                descriptionView.text = description
                maxTemperatureView.text = "$high"
                minTemperatureView.text = "$low"
                itemView.setOnClickListener { itemClick(this) }

            }

        }
    }

    interface OnItemClickListener {
        operator fun invoke(forecast: Forecast)
    }
}