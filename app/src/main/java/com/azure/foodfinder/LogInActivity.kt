package com.azure.foodfinder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import com.azure.foodfinder.Navigation.Navigator.ChangeFragment
import com.azure.foodfinder.fragments.ListFragment
import com.azure.foodfinder.fragments.logIn.LogInFragment
import kotlinx.android.synthetic.main.fragment_register.*


class LogInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        ChangeFragment(this, LogInFragment(), R.id.loginFrame, "loginFragment", false)


    }


}
