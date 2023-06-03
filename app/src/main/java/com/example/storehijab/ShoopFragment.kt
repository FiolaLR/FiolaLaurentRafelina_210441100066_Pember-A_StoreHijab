package com.example.storehijab

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.storehijab.adapter.Adapterpengguna
import com.example.storehijab.dataa.AppDatabase
import com.example.storehijab.dataa.entity.pengguna
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ShoopFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var fab: FloatingActionButton
    private var list = mutableListOf<pengguna>()
    private lateinit var adapter: Adapterpengguna
    private lateinit var database: AppDatabase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_shoop, container, false)

        recyclerView = view.findViewById(R.id.rvDailyActivity)
        fab = view.findViewById(R.id.btnTambah)

        database = AppDatabase.getInstance(requireContext())
        adapter = Adapterpengguna(list)

        // Set the click listener for the adapter items
        adapter.setpopup(object : Adapterpengguna.Poopup {
            override fun onClick(position: Int) {
                val popup = AlertDialog.Builder(requireContext())
                popup.setTitle(list[position].fullName)
                popup.setItems(R.array.option, DialogInterface.OnClickListener { popup, which ->
                    if (which == 0) {
                        val intent = Intent(requireContext(), datapesan::class.java)
                        intent.putExtra("id", list[position].uid)
                        startActivity(intent)
                    } else if (which == 1) {
                        database.PenggunaDao().delete(list[position])
                        getData()
                    } else {
                        popup.dismiss()
                    }
                })
                val popupView = popup.create()
                popupView.show()
            }
        })

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.addItemDecoration(DividerItemDecoration(requireContext(), VERTICAL))

        fab.setOnClickListener{
            startActivity(Intent(requireContext(), datapesan::class.java))
        }

        return view
    }

    override fun onResume() {
        super.onResume()
        getData()
    }

    private fun getData() {
        list.clear()
        list.addAll(database.PenggunaDao().getAll())
        adapter.notifyDataSetChanged()
    }
}
