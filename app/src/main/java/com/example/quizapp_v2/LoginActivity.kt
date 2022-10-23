package com.example.quizapp_v2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun start(view: View) {
        var intent = Intent(this,MainActivity::class.java)
        startActivity(intent);
        finish();
    }
}