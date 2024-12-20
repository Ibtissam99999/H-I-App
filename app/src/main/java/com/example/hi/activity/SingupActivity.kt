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

class SingupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_singup)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btn = findViewById<Button>(R.id.btnSign)
        val txSignin = findViewById<TextView>(R.id.txSignin)

        btn.setOnClickListener{
            val intent = Intent(this,HomeActivity::class.java)
            intent.putExtra("SignIn",btn.text.toString())
            startActivity(intent)
        }

        txSignin.setOnClickListener{
            val intentS = Intent(this,LoginActivity::class.java)
            intentS.putExtra("SignIn",txSignin.text)
            startActivity(intentS)
        }
    }
}