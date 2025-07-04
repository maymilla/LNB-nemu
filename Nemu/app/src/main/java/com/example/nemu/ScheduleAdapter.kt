package com.example.nemu

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ScheduleAdapter(private val items: List<PlaceItem>) :
    RecyclerView.Adapter<ScheduleAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTimeline: TextView = view.findViewById(R.id.name_timeline)
        val addressTimeline: TextView = view.findViewById(R.id.address_timeline)
        val photoTimeline: ImageView = view.findViewById(R.id.photo_timeline)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.timeline_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.nameTimeline.text = item.name
        holder.addressTimeline.text = item.address
        holder.photoTimeline.setImageResource(item.photos[0])
    }
}

