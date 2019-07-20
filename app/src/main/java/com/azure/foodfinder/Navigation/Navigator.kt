package com.azure.foodfinder.Navigation

import android.content.Context
import android.content.Intent
import android.inputmethodservice.ExtractEditText
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import com.azure.foodfinder.R
import java.io.Serializable

object Navigator{


//Function to navigate between fragments
fun ChangeFragment(activity: AppCompatActivity?, fragment: Fragment, name: String, backStack: Boolean = true ){
    val navigate = activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.mainFrame, fragment, "redFragment")
    if(backStack){
        navigate?.addToBackStack(name)?.commit()
    }else{
        navigate?.commit()
    }
}
    //Function to change activity
    /*fun ChangeActivity(activity: AppCompatActivity, context: Context, withExtra: Boolean,
                       extra:Serializable?, extraName: String? ): Intent{
        var intent = Intent(context, activity::class.java)
        if(withExtra){
            intent.putExtra(extraName, extra)
            return intent
        }else{
            return intent
        }
    }*/

}