package com.example.storehijab

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    lateinit var recycle: RecyclerView
    lateinit var recycleAdapter: AdapterData
    lateinit var listData: ArrayList<ClassData>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        recycle = view.findViewById(R.id.idRVCourses)
        listData = ArrayList()

        val layoutManager = GridLayoutManager(context, 2) // Use 'context' instead of 'this'
        recycle.layoutManager = layoutManager
        recycleAdapter = AdapterData(listData, requireContext()) // Use 'requireContext()' instead of 'this'

        recycle.adapter = recycleAdapter
        listData.add(ClassData("CERUTY", "RP 20.000",R.drawable.cerutymaroon))
        listData.add(ClassData("PLISKET", "RP 25.000",R.drawable.plisketpink))
        listData.add(ClassData("CRINGKEL", "RP 28.000",R.drawable.cringkelcapucino))
        listData.add(ClassData("BELA SQUARE", "RP 15.000",R.drawable.segitiga3))

        val imageView = view.findViewById<ImageView>(R.id.search)
        val editText = view.findViewById<EditText>(R.id.edsearch)

        val linearLayoutscroll = view.findViewById<ImageView>(R.id.pasmina)
        linearLayoutscroll.setOnClickListener {
            val intent = Intent(requireActivity(), MainActivity3::class.java)
            startActivity(intent)
        }

        val linearLayoutscroll1 = view.findViewById<ImageView>(R.id.segitiga)
        linearLayoutscroll1.setOnClickListener {
            val intent = Intent(requireActivity(), MainActivity4::class.java)
            startActivity(intent)
        }

        imageView.setOnClickListener {
            if (editText.visibility == View.GONE) {
                editText.visibility = View.VISIBLE
            } else {
                editText.visibility = View.GONE
            }
        }

        return view
    }
}
