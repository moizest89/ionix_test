package com.moizest89.ionix_test.presentation.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.moizest89.ionix_test.R
import com.moizest89.ionix_test.framework.setMask
import com.moizest89.ionix_test.presentation.dialog.ProgressDialog
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() , IMainView{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        this.cardViewPay.setOnClickListener {
            getRutNumberInformation()
        }

    }

    override fun getRutNumberInformation() {
        val dialogBuilder = AlertDialog.Builder( this )
        dialogBuilder.setMessage( R.string.dialog_message )
        val dialogView: View = layoutInflater.inflate(R.layout.item_edit_text, null)
        dialogBuilder.setView(dialogView)
        val mEditText = dialogView.findViewById< TextInputEditText >(R.id.editText)
        mEditText.setMask("########-#")
        mEditText.requestFocus()
        dialogBuilder.setPositiveButton( android.R.string.ok) { _, _ ->
            searchRutInformation( mEditText.text.toString().trim().replace("-",""))
        }
        val alertDialog: AlertDialog = dialogBuilder.create()
        alertDialog.show()
    }

    override fun searchRutInformation(rutNumber: String) {
        
    }



    companion object{
        fun log( message : String ){
            Log.e( MainActivity::class.java.simpleName , message )
        }
    }

}