package com.example.quizapp_v2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Constants
import android.view.View
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        findViewById<TextView>(R.id.textView12).text = intent.getStringExtra(Constants.ACCOUNT_NAME)
    }
    fun changLogin(_view: View){
        var intent = Intent(this,LoginActivity::class.java)
        startActivity(intent);
        finish();
    }
}