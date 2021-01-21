package com.dev.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dev.details.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    companion object{
        var data: Details? = null
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        if(data != null){
            binding.userName.text = data?.userName
            binding.email.text = data?.email
            binding.phone.text = data?.phone
            binding.password.text = data?.password
        }
        setContentView(binding.root)
    }
}