package com.example.storehijab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Phone
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.storehijab.dataa.AppDatabase
import com.example.storehijab.dataa.entity.pengguna

class datapesan : AppCompatActivity() {

    private lateinit var fullName: EditText
    private lateinit var alamat: EditText
    private lateinit var phone: EditText
    private lateinit var email: EditText
    private lateinit var btnsave: Button
    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datapesan)

        fullName = findViewById(R.id.Nama)
        alamat = findViewById(R.id.Alamat)
        phone = findViewById(R.id.Phone)
        email = findViewById(R.id.Email)
        btnsave = findViewById(R.id.addsave)

        database = AppDatabase.getInstance(applicationContext)

        val intent = intent.extras
        if (intent!=null){
            val id = intent.getInt("id",0)
            val pengguna = database.PenggunaDao().get(id)

            fullName.setText(pengguna.fullName)
            alamat.setText(pengguna.alamat)
            phone.setText(pengguna.phone)
            email.setText(pengguna.email)

        }

        btnsave.setOnClickListener {
            if(fullName.text.isNotEmpty() && alamat.text.isNotEmpty() && phone.text.isNotEmpty() && email.text.isNotEmpty()){
              if (intent!=null){
                  database.PenggunaDao().update(
                      pengguna(
                          intent.getInt("id",0),
                          fullName.text.toString(),
                          alamat.text.toString(),
                          phone.text.toString(),
                          email.text.toString()
                      ))
              }else{
                  database.PenggunaDao().insertAll(pengguna(
                      null,
                      fullName.text.toString(),
                      alamat.text.toString(),
                      phone.text.toString(),
                      email.text.toString()
                  ))
              }

                finish()
            }else{
                Toast.makeText(applicationContext, "Data masih belum lengkap", Toast.LENGTH_SHORT).show()
            }
        }
    }
}