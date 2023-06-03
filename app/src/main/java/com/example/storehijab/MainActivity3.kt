package com.example.storehijab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity3 : AppCompatActivity() {

    lateinit var recycle3: RecyclerView
    lateinit var recycleAdapter3: AdapterData
    lateinit var listData3: ArrayList<ClassData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        recycle3 = findViewById(R.id.idRVCourses3)
        listData3 = ArrayList()

        val layoutManager = GridLayoutManager(this, 2)
        recycle3.layoutManager = layoutManager
        recycleAdapter3 = AdapterData(listData3, this)

// recycleview
        recycle3.adapter = recycleAdapter3
        listData3.add(ClassData(" plisket", "RP 25.000",R.drawable.plisketpink))
        listData3.add(ClassData(" plisket", "RP 25.000",R.drawable.pliskethitam))
        listData3.add(ClassData(" plisket", "RP 25.000",R.drawable.plisketnavy))
        listData3.add(ClassData(" Plisket", "RP 25.000",R.drawable.plisketputih))
        listData3.add(ClassData(" cringkel", "RP 28.000",R.drawable.cringkelcapucino))
        listData3.add(ClassData(" cringkel", "RP 28.000",R.drawable.cringkelcoksu))
        listData3.add(ClassData(" cringkel", "RP 28.000",R.drawable.cringkelhijau))
        listData3.add(ClassData(" cringkel", "RP 28.000",R.drawable.cringkelmatcha))
        listData3.add(ClassData(" Ceruty", "RP 20.000",R.drawable.cerutyabu))
        listData3.add(ClassData(" Ceruty", "RP 20.000",R.drawable.cerutymaroon))
        listData3.add(ClassData(" Ceruty", "RP 20.000",R.drawable.cerutymustard))


    }
}