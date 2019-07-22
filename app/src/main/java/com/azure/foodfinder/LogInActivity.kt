package com.azure.foodfinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.azure.foodfinder.Navigation.Navigator.ChangeFragment
import com.azure.foodfinder.fragments.ListFragment
import com.azure.foodfinder.fragments.logIn.LogInFragment

class LogInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        ChangeFragment(this, LogInFragment(), R.id.loginFrame, "loginFragment", false)

    }
}
