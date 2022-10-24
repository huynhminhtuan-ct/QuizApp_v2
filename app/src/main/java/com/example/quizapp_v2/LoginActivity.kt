package com.example.quizapp_v2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Constants
import android.view.View
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun start(view: View) {
        //
        var outlinedTextField: TextInputLayout = findViewById(R.id.outlinedTextField)
        var userName: TextView? = findViewById(R.id.userName)
        if(userName?.text.toString()?.trim()?.compareTo("")==0){
            outlinedTextField.setError("Name cannot be left blank");
        }
        else{
            outlinedTextField.setError(null);
            var intent = Intent(this,MainActivity::class.java)
            intent.putExtra(Constants.ACCOUNT_NAME,userName?.text.toString()?.trim())
            startActivity(intent);
            finish();
        }

    }
}