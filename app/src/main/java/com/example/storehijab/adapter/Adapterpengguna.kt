package com.example.storehijab.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.storehijab.R
import com.example.storehijab.dataa.entity.pengguna

class Adapterpengguna(var list: List<pengguna>):
    RecyclerView.Adapter<Adapterpengguna.ViewHolder>() {
    private lateinit var popup: Poopup

    fun setpopup(popup: Poopup){
        this.popup = popup
    }

    interface Poopup {
        fun onClick(position: Int)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var fullName: TextView
        var alamat: TextView
        var phone: TextView
        var email: TextView

        init {
            fullName = view.findViewById(R.id.tvTitleFinalValue)
            alamat = view.findViewById(R.id.tvRangeTimeStartValueFinal)
            phone = view.findViewById(R.id.tvDescValueFinal)
            email = view.findViewById(R.id.tvphonefinal)
            view.setOnClickListener{
                popup.onClick(layoutPosition)
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ropengguna, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.fullName.text = list[position].fullName
        holder.alamat.text = list[position].alamat
        holder.phone.text = list[position].phone
        holder.email.text = list[position].email
    }
}