package com.dev.loginandsignup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.dev.details.DetailActivity
import com.dev.details.Details
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
                    DetailActivity.data = Details(signUpDetails.userName, signUpDetails.email, signUpDetails.phone, signUpDetails.password)
                    intent = Intent(this@MainActivity, Class.forName("com.dev.details.DetailActivity"))
                    startActivity(intent)
                }catch (ex: ClassNotFoundException){
                    ex.printStackTrace()
                }
            }else{
                Toast.makeText(this@MainActivity, "This username doesn't have any account. Please create an account and try again.", Toast.LENGTH_LONG).show()
            }
        }

        setContentView(binding.root)

    }

    override fun onResume() {
        super.onResume()
        Log.e("Dev", SignUpActivity.signUpDetails.toString())
    }
}