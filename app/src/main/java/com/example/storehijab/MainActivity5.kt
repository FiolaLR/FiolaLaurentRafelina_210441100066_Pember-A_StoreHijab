package com.example.storehijab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        // deklarasi view berdasarkan id
        val btnSubmitEditData = findViewById<Button>(R.id.buttonsimpandata)
        val inputName = findViewById<EditText>(R.id.edtName)


        // Mendapatkan nilai default dari Intent
        val nama = intent.getStringExtra("nama")


        // Menampilkan nilai default di inputan
        inputName.setText(nama)


        // ketika tombol submit diklik, maka akan kembali ke fragmentaccount
        btnSubmitEditData.setOnClickListener {
            val intent = intent

            // mengirimkan data ke fragment account
            intent.putExtra("nama", inputName.text.toString())

            // mengirimkan result ke fragmentaccount
            setResult(RESULT_OK, intent)

            // menutup ActivityEdit
            finish()
        }
    }
}

//modul5