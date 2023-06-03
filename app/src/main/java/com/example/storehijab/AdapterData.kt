package com.example.storehijab

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class AdapterData (private val Datadata: ArrayList<ClassData>, private val context: Context): RecyclerView.Adapter<AdapterData.CourseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterData.CourseViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.view,
            parent, false
        )
        return CourseViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: AdapterData.CourseViewHolder, position: Int) {
        holder.nama.text = Datadata.get(position).name
        holder.harga.text = Datadata.get(position).harga
        holder.foto.setImageResource(Datadata.get(position).Img)
    }
    override fun getItemCount(): Int {
        return Datadata.size
    }
    class CourseViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foto: ImageView = itemView.findViewById(R.id.idfoto)
        val nama: TextView = itemView.findViewById(R.id.idtvname)
        val harga: TextView = itemView.findViewById(R.id.idtvharga)



    }
}

