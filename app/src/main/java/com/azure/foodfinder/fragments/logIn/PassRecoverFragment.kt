package com.azure.foodfinder.fragments.logIn


import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.azure.foodfinder.MainActivity
import com.azure.foodfinder.Navigation.Navigator

import com.azure.foodfinder.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_pass_recover.*


class PassRecoverFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pass_recover, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recoverPass()
    }

    private fun recoverPass(){
        emailRecoverBtn.setOnClickListener{
            val auth = FirebaseAuth.getInstance()
            val email = emailRecoverInput.text.toString()
            auth.sendPasswordResetEmail(email).addOnCompleteListener{task ->
                if (task.isSuccessful()) {
                    Log.d(TAG, "Email sent.")
                    Toast.makeText(context, "Email sent.", Toast.LENGTH_LONG)
                }
            }
        }
    }

}
