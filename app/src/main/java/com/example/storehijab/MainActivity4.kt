package com.example.storehijab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity4 : AppCompatActivity() {

    lateinit var recycle1: RecyclerView
    lateinit var recycleAdapter1: AdapterData
    lateinit var listData1: ArrayList<ClassData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        recycle1 = findViewById(R.id.idRVCourses2)
        listData1 = ArrayList()

        val layoutManager = GridLayoutManager(this, 2)
        recycle1.layoutManager = layoutManager
        recycleAdapter1 = AdapterData(listData1, this)

        recycle1.adapter = recycleAdapter1
        listData1.add(ClassData("Bela Square", "RP 15.000",R.drawable.segitiga1))
        listData1.add(ClassData("Bela Square", "RP 15.000",R.drawable.segitiga2))
        listData1.add(ClassData("Bela Square", "RP 15.000",R.drawable.segitiga3))
        listData1.add(ClassData("Bela Square", "RP 15.000",R.drawable.segitiga4))
        listData1.add(ClassData("Bela Square", "RP 15.000",R.drawable.segitiga5))
        listData1.add(ClassData("Paris", "RP 18.000",R.drawable.pasmina6))
        listData1.add(ClassData("Paris", "RP 18.000",R.drawable.pasmina7))
        listData1.add(ClassData("Paris", "RP 18.000",R.drawable.pasmina8))
        listData1.add(ClassData("Paris", "RP 18.000",R.drawable.pasmina9))
        listData1.add(ClassData("Paris", "RP 18.000",R.drawable.pasmina10))
    }
}
