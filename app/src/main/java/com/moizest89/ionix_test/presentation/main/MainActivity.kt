package com.moizest89.ionix_test.presentation.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.google.android.material.textfield.TextInputEditText
import com.moizest89.ionix_test.R
import com.moizest89.ionix_test.domain.Item
import com.moizest89.ionix_test.framework.setMask
import com.moizest89.ionix_test.presentation.dialog.ProgressDialog
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() , IMainView{


    private val mainViewModel : MainViewModel by viewModel()

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

        this.mainViewModel.searchRutInformation( rutNumber ).observe( this , Observer { liveData ->
            liveData.onSuccess {
                ProgressDialog.hide()
                it.result?.let {result ->
                    if( result.items.isNullOrEmpty() && result.items.size >= 2){
                        showSandboxItemInformation( result.items[1] )
                    }else{
                        showSandboxItemInformation( null )
                    }
                }?:run { showSandboxItemInformation( null ) }

            }
            liveData.onLoading {
                ProgressDialog.show( this@MainActivity )
            }
            liveData.onFailure {
                ProgressDialog.hide()
                showErrorMessage( it )
            }
        })
    }

    override fun showSandboxItemInformation( item: Item? ) {

        val message = item?.let {
                    "Nombre: ${it.name}\n" +
                    "Email: ${it.detail?.email}\n" +
                    "Reléfono: ${it.detail?.phoneNumber}"
        }?:run{
            "No hay informacion por mostrar"
        }

        AlertDialog.Builder( this )
            .setMessage( message )
            .setPositiveButton( android.R.string.ok){ _ , _ ->

            }.create().show()
    }

    override fun showErrorMessage(error: Throwable? ) {
        AlertDialog.Builder( this )
            .setMessage( error?.message )
            .setPositiveButton( android.R.string.ok){ _ , _ ->

            }.create().show()
    }


    companion object{
        fun log( message : String ){
            Log.e( MainActivity::class.java.simpleName , message )
        }
    }

}