package com.azure.foodfinder.fragments.logIn

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.azure.foodfinder.MainActivity
import com.azure.foodfinder.Navigation.Navigator.ChangeActivity
import com.azure.foodfinder.Navigation.Navigator.ChangeFragment
import com.azure.foodfinder.R
import com.azure.foodfinder.dataClasses.principales.User
import com.azure.foodfinder.firebaseLogic.FirebaseLogic
import com.azure.foodfinder.firebaseLogic.FirebaseLogic.createUser
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment : Fragment() {

    lateinit var TAG : String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        TAG = "register"
        registerBtn.setOnClickListener {

            val UN = userName.text.toString()
            val uid = FirebaseLogic.auth.uid ?: ""
            val favRecipe = ArrayList<String>()
            val user = User(UN, uid, favRecipe)
            if(!createUser(emailInput, passwordInput, userName, context, user)){
                Log.v(TAG, "something went wrong ma boy")
            }
            Log.v(TAG, "It's entering here")
            startActivity(ChangeActivity(MainActivity(), context, false))
            activity?.finish()
        }




    }

}

