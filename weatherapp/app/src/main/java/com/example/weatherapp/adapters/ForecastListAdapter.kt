package com.example.weatherapp.adapters

import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 *  clase que hace de puente entre la vista (el recyclerview) y los datos
 *
 *  -Con private se asegura que solo será usado en esta clase
 */
class ForecastListAdapter(private val items: List<String>): RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    /**
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        return ViewHolder(TextView(parent.context))
    }*/

    /**
     * Less boilerPlate, tha line before
    * */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
        ViewHolder(TextView(parent.context))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = items[position]
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

}