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
import com.azure.foodfinder.Navigation.Navigator.ChangeFragment
import com.azure.foodfinder.R
import com.azure.foodfinder.dataClasses.principales.User
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
        TAG = "Main"
        registerBtn.setOnClickListener {


            createUser()

        }




    }

    fun createUser(){
        val email = emailInput.text.toString()
        val password = passwordInput.text.toString()
        if(email.isEmpty() && password.isEmpty()){
            Toast.makeText(context, "Please, input email and pasword to create a user", Toast.LENGTH_SHORT).show()
        }
        val auth = FirebaseAuth.getInstance()

        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                val user = FirebaseAuth.getInstance().currentUser
                Log.d(TAG, "createUserWithEmail:success, user uid: ${user?.uid}")
                startActivity( ChangeActivity(MainActivity(), context, false))
                saveUserToFirebaseDataBase()
                activity?.finish()


            } else {
                // If sign in fails, display a message to the user.
                Log.w(TAG, "createUserWithEmail:failure", task.exception)
                Toast.makeText(
                    context, "Authentication failed. ${task.exception}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }


    }

    fun saveUserToFirebaseDataBase(){

        val uid = FirebaseAuth.getInstance().uid ?: ""
        val db = FirebaseDatabase.getInstance().reference
        val userName = userName.text.toString()
        val user = User(userName, uid)
        Log.d("Main", user.toString())
        db.child("users").child("UID").setValue(uid)
        db.child("users").child(uid).setValue(user)

    }


}

