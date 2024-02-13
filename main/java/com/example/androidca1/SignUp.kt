package com.example.androidca1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class SignUp : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var pass: EditText
    lateinit var signup: Button
    lateinit var a: FirebaseAuth
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        a = FirebaseAuth.getInstance()
        email = findViewById(R.id.email)
        pass = findViewById(R.id.pass)
        signup = findViewById(R.id.signup)
        signup.setOnClickListener {
            if (pass.text.toString().contains('@')) {
                a.createUserWithEmailAndPassword(email.text.toString(), pass.text.toString())
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            Toast.makeText(this, "SignUp Success" + it.exception, Toast.LENGTH_LONG)
                                .show()
                        } else {
                            Toast.makeText(this, "SignUp Failed" + it.exception, Toast.LENGTH_LONG)
                                .show()
                        }
                    }
            } else {
                Toast.makeText(this, "Password must contain @", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }
}