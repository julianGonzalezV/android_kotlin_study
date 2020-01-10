package com.example.weatherapp.adapters

import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 *  clase que hace de puente entre la vista (el recyclerview) y los datos
 * - RecicleView es sucesor de ListView
 *  -Con private se asegura que solo será usado en esta clase, evtando
 *  el side efecto y aydando al encapsulamiento
 */
class ForecastListAdapter(private val items: List<String>): RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    /**
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        return ViewHolder(TextView(parent.context))
    }*/

    /**
     * Less boilerPlate, that line before
     * Se debe sobre-escribir este método para
     * inflate the view and its view holder
    * */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
        ViewHolder(TextView(parent.context))

    /**
     * Se sobre-escribe esta para asociar los datos a la vista
     * en esta ocacion se asocia un tipo de vista textView, osea que
     * todos los elemento de items será mostrado en texto
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = items[position]
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

}