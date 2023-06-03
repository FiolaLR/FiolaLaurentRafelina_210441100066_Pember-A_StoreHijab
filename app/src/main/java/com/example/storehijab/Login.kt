package com.example.storehijab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class Login : AppCompatActivity() {
    private val usernameUser = "fio"
    private val passwordUser = "021002"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val edtUsername = findViewById<TextInputEditText>(R.id.edtUsername)
        val edtPassword = findViewById<TextInputEditText>(R.id.edtPassword)
        val cbTampil = findViewById<CheckBox>(R.id.cbTampil)
        val button = findViewById<Button>(R.id.button)

        //guna menghide password
        cbTampil.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                edtPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
            } else {
                edtPassword.transformationMethod = PasswordTransformationMethod.getInstance()
            }
        }

        button.setOnClickListener {
            val usernameInput = edtUsername.text.toString()
            val passwordInput = edtPassword.text.toString()

//jika kosong line 38-42
//jika salah line 44-48
            if (usernameInput == "") {
                Toast.makeText(this, "Harap masukan User", Toast.LENGTH_SHORT).show()
            } else if (passwordInput == "") {
                Toast.makeText(this, "Harap masukan Password", Toast.LENGTH_SHORT).show()
            } else {
                if (usernameInput != usernameUser) {
                    Toast.makeText(this, "Username salah", Toast.LENGTH_SHORT).show()
                } else if (passwordInput != passwordUser) {
                    Toast.makeText(this, "Password salah", Toast.LENGTH_SHORT).show()
                } else {
                    val intent = Intent(this, MainActivity2::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }
}