package com.example.demoapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        auth = Firebase.auth

        val user = auth.currentUser
        if(user!=null){
            val intent = Intent(this, BottomNavActivity::class.java)
            startActivity(intent)
        }


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val submit = findViewById<Button>(R.id.submit)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        submit.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            createAccount(email, password)
        }

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }


    private fun createAccount(email: String, password: String) {
        // [START create_user_with_email]
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val intent = Intent(this, BottomNavActivity::class.java)
                    startActivity(intent)
                    // Sign in success, update UI with the signed-in user's information
                    Toast.makeText(baseContext, "Authentication Successful.", Toast.LENGTH_SHORT).show()
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(baseContext, "Authentication failed.", Toast.LENGTH_SHORT).show()
                }
            }
    }

}