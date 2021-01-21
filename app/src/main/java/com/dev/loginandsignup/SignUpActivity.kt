package com.dev.loginandsignup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dev.loginandsignup.databinding.ActivitySignupBinding

class SignUpActivity: AppCompatActivity() {

    companion object{
        var signUpDetails: SignupDetails? = null
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySignupBinding.inflate(layoutInflater)

        binding.signup.setOnClickListener {
            signUpDetails = SignupDetails(binding.userName.text.toString(),
                                            binding.email.text.toString(),
                                            binding.phone.text.toString(),
                                            binding.password.text.toString())
        this@SignUpActivity.finish()}

        setContentView(binding.root)

    }
}