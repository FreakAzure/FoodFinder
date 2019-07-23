package com.azure.foodfinder.firebaseLogic

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.azure.foodfinder.MainActivity
import com.azure.foodfinder.Navigation.Navigator
import com.azure.foodfinder.dataClasses.principales.User
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_log_in.*
import kotlinx.android.synthetic.main.fragment_register.*
import org.w3c.dom.Text

object FirebaseLogic{
    val TAG = "FIREBASE"
    val auth = FirebaseAuth.getInstance()





    //Create a new user to the Log in module
    fun createUser(emailInput: TextInputEditText, passwordInput: TextInputEditText, userName: TextInputEditText, context: Context?): Boolean{
        val email = emailInput.text.toString()
        val password = passwordInput.text.toString()
        var success = false
        if(email.isEmpty() && password.isEmpty()){
            Toast.makeText(context, "Please, input email and pasword to create a user", Toast.LENGTH_SHORT).show()
        }

        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                val user = FirebaseAuth.getInstance().currentUser
                Log.d(TAG, "createUserWithEmail:success, user uid: ${user?.uid}")
                saveUserToFirebaseDataBase(userName)
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
    fun saveUserToFirebaseDataBase(userName: TextInputEditText){

        val uid = auth.uid ?: ""
        val db = FirebaseDatabase.getInstance().getReference("/users/$uid")
        val UserName = userName.text.toString()
        val favRecipe = ArrayList<String>()
        favRecipe.add("")
        val user = User(UserName, uid, favRecipe)
        Log.d("register", "it entered here")
        db.setValue(user)
            .addOnSuccessListener {
                Log.d("register", "Succesfully uploaded user data to database with value ${user}")
            }

    }

    //Log in a existent user
    fun LogIn(loginEmail: TextInputEditText, loginPass:TextInputEditText, context: Context){
        val email = loginEmail.text.toString()
        val password = loginPass.text.toString()
        val auth = FirebaseAuth.getInstance()
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener{ task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val user = auth.currentUser
                    Log.d(TAG, "signInWithEmail:success")


                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(context, "Authentication failed: ${task.exception}",
                        Toast.LENGTH_SHORT).show()

                }

                // ...
            }
    }

}