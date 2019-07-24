package com.azure.foodfinder.firebaseLogic

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.azure.foodfinder.dataClasses.principales.User
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import java.io.Serializable

object FirebaseLogic {
    val TAG = "FIREBASE"
    val auth = FirebaseAuth.getInstance()
    val uid = auth.uid ?: ""
    val database = FirebaseDatabase.getInstance().getReference("/users/$uid")


    //Create a new user to the Log in module
    fun createUser(
        emailInput: TextInputEditText, passwordInput: TextInputEditText,
        userName: TextInputEditText, context: Context?, Object: Serializable? = null
    ): Boolean {
        val email = emailInput.text.toString()
        val password = passwordInput.text.toString()
        var success = false
        if (email.isEmpty() && password.isEmpty()) {
            Toast.makeText(context, "Please, input email and pasword to create a user", Toast.LENGTH_SHORT).show()
        }

        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                val user = FirebaseAuth.getInstance().currentUser
                Log.d(TAG, "createUserWithEmail:success, user uid: ${user?.uid}")
                saveUserToFirebaseDataBase(userName, Object)
                success = true


            } else {
                // If sign in fails, display a message to the user.
                Log.w(TAG, "createUserWithEmail:failure", task.exception)
                Toast.makeText(
                    context, "Authentication failed. ${task.exception}",
                    Toast.LENGTH_LONG
                ).show()
                success = false
            }
        }
        return success

    }

    //upload the rest of the user data to Firaebase Realtime Database.
    //User name, UID and favorite recipes (which are still not implemented yet)
    fun saveUserToFirebaseDataBase(userName: TextInputEditText, Object: Serializable? = null) {
        val UserName = userName.text.toString()
        val favRecipe = ArrayList<String>()
        favRecipe.add("")
        val user = User(UserName, uid, favRecipe)
        Log.d("register", "it entered here")
        database.setValue(Object)
            .addOnSuccessListener {
                Log.d("register", "Succesfully uploaded user data to database with value ${user}")
            }

    }

    //Log in a existent user
    fun LogIn(loginEmail: TextInputEditText, loginPass: TextInputEditText, context: Context?): Boolean {
        val email = loginEmail.text.toString()
        val password = loginPass.text.toString()
        var success = false
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val user = auth.currentUser
                    Log.d(TAG, "signInWithEmail:success")
                    success = true

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(
                        context, "Authentication failed: ${task.exception}",
                        Toast.LENGTH_SHORT
                    ).show()
                    success = false
                }

                // ...
            }
        return success
    }

    fun addToFav(favUri: String) {
        //add favorite recipes
    }

}