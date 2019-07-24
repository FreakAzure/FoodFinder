package com.azure.foodfinder.fragments.logIn

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.azure.foodfinder.MainActivity
import com.azure.foodfinder.Navigation.Navigator.ChangeActivity
import com.azure.foodfinder.R
import com.azure.foodfinder.firebaseLogic.FirebaseLogic.LogIn
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_log_in.*


class LogInFragment : Fragment() {

    lateinit var TAG: String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_log_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        TAG = "Main"
        RegisterButton.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.replace(
                R.id.loginFrame,
                RegisterFragment(), "registerFragment"
            )?.addToBackStack("registerFragment")?.commit()
        }
        logInBtn.setOnClickListener {
            if(!LogIn(loginEmail,loginPass,context)){
                Log.d(TAG, "Log in failed")
            }
            startActivity(ChangeActivity(MainActivity(), context, false))
            activity?.finish()
        }

        RecoverBtn.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.replace(
                R.id.loginFrame,
                PassRecoverFragment(), "passRecover"
            )?.addToBackStack("PassRecover")?.commit()
        }


    }


}
