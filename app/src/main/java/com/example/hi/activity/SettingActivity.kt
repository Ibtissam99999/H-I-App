package com.example.hi.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.hi.R

class SettingActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_setting)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //back
        val back = findViewById<ImageButton>(R.id.imageButton)
        back.setOnClickListener{
            val intent = Intent(this,UserActivity::class.java)
            startActivity(intent)
        }

        val loc = findViewById<ImageButton>(R.id.loc)
        loc.setOnClickListener{
            val intent = Intent(this,LocationActivity::class.java)
            startActivity(intent)
        }

        val lang = findViewById<ImageButton>(R.id.lang)
        lang.setOnClickListener{
            val intent = Intent(this,LanguageActivity::class.java)
            startActivity(intent)
        }

        val about = findViewById<ImageButton>(R.id.about)
        about.setOnClickListener{
            val intent = Intent(this,AboutActivity::class.java)
            startActivity(intent)
        }

        val payment = findViewById<ImageButton>(R.id.payement)
        payment.setOnClickListener{
            val intent = Intent(this,UserActivity::class.java)
            startActivity(intent)
        }

        val logout = findViewById<TextView>(R.id.logout)
        logout.setOnClickListener{
            val intent = Intent(this,IntroActivity::class.java)
            startActivity(intent)
        }
    }
}