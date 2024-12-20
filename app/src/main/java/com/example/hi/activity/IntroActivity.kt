package com.example.hi.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.hi.R

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_intro)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btn = findViewById<Button>(R.id.signIn)
        val txSign = findViewById<TextView>(R.id.signUp)

        btn.setOnClickListener{
            val intent = Intent(this,HomeActivity::class.java)
            intent.putExtra("SignIn",btn.text.toString())
            startActivity(intent)
        }

        txSign.setOnClickListener{
            val intentS = Intent(this,LoginActivity::class.java)
            intentS.putExtra("SignUp",txSign.text)
            startActivity(intentS)
        }
    }
}