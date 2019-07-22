package com.azure.foodfinder
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import com.azure.foodfinder.Navigation.Navigator.ChangeActivity
import com.azure.foodfinder.Navigation.Navigator.ChangeFragment
import com.azure.foodfinder.fragments.ListFragment
import com.azure.foodfinder.fragments.logIn.LogInFragment
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_register.*


class LogInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        val auth = FirebaseAuth.getInstance()
        if (auth.getCurrentUser() != null) {
            // User is signed in (getCurrentUser() will be null if not signed in)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        ChangeFragment(this, LogInFragment(), R.id.loginFrame, "loginFragment", false)


    }


}
