package com.dev.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dev.details.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val data = SignUpActivity.signUpDetails
        if(data != null){
            binding.userName.text = data.userName
            binding.email.text = data.email
            binding.phone.text = data.phone
            binding.password.text = data.password
        }
        setContentView(binding.root)
    }
}