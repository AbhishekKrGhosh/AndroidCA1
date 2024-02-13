package com.example.androidca1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var pass: EditText
    lateinit var login: Button
    private lateinit var a: FirebaseAuth
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        a = FirebaseAuth.getInstance()
        email = findViewById(R.id.emailLogin)
        pass = findViewById(R.id.passLogin)
        login = findViewById(R.id.login)
        var e = email.text.toString()
        var p = pass.text.toString()


        a.signInWithEmailAndPassword(e,p)
            .addOnCompleteListener{
                if(it.isSuccessful){
                    Toast.makeText(this, "Login Success", Toast.LENGTH_LONG).show()
                    intent = Intent.parseIntent(MainActivity::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this, "Error" + it.exception, Toast.LENGTH_LONG).show()
                }
            }
    }
}