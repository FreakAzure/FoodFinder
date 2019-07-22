package com.azure.foodfinder.fragments.logIn

import android.app.Activity
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
import com.azure.foodfinder.fragments.RecipeFragment
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
        RegisterButton.setOnClickListener{
            activity?.supportFragmentManager?.beginTransaction()?.replace(
                R.id.loginFrame,
                RegisterFragment(), "registerFragment"
            )?.addToBackStack("redFragment")?.commit()
        }
        logInBtn.setOnClickListener{
            signIn()
        }


    }
    fun signIn(){
        val email = loginEmail.text.toString()
        val password = loginPass.text.toString()
        val auth = FirebaseAuth.getInstance()
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener{ task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val user = auth.currentUser
                    Log.d(TAG, "signInWithEmail:success")
                    startActivity(ChangeActivity(MainActivity(), context, false))
                    activity?.finish()


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
