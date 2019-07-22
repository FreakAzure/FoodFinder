package com.azure.foodfinder.firebase

import com.google.firebase.auth.FirebaseAuth

object FirebaseLogic{
    private lateinit var auth: FirebaseAuth


    fun firebaseAuth(){
        auth = FirebaseAuth.getInstance()
    }



}