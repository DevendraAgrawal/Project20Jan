package com.dev.loginandsignup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.dev.loginandsignup.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        binding.signupBtn.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        binding.logInBtn.setOnClickListener {
            val signUpDetails = SignUpActivity.signUpDetails
            if(signUpDetails != null && binding.userName.text.toString().equals(signUpDetails.userName) && binding.password.text.toString().equals(signUpDetails.password)){

                val intent: Intent
                try{

                    intent = Intent(this@MainActivity, Class.forName("com.dev.details.MainActivity"))
                    startActivity(intent)
                }catch (ex: ClassNotFoundException){
                    ex.printStackTrace()
                }
            }else{
                Toast.makeText(this@MainActivity, "Something went wrong! Please try again later.", Toast.LENGTH_LONG).show()
            }
        }

        setContentView(binding.root)

    }

    override fun onResume() {
        super.onResume()
        Log.e("Dev", SignUpActivity.signUpDetails.toString())
    }
}