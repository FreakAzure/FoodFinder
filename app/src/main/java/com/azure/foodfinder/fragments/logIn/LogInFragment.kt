package com.azure.foodfinder.fragments.logIn

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.azure.foodfinder.Navigation.Navigator.ChangeFragment
import com.azure.foodfinder.R
import com.azure.foodfinder.fragments.RecipeFragment
import kotlinx.android.synthetic.main.fragment_log_in.*


class LogInFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_log_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        RegisterButton.setOnClickListener{
            activity?.supportFragmentManager?.beginTransaction()?.replace(
                R.id.loginFrame,
                RegisterFragment(), "registerFragment"
            )?.addToBackStack("redFragment")?.commit()
        }

    }

}
