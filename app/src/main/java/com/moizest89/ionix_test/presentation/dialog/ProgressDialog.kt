package com.moizest89.ionix_test.presentation.dialog

import android.app.Dialog
import android.content.Context
import android.view.Window
import android.view.WindowManager
import com.moizest89.ionix_test.R

object ProgressDialog {

    private var dialog : Dialog? = null

    fun show( context: Context ) : Dialog{

        if( dialog == null ) {
            dialog = Dialog( context )
            dialog!!.requestWindowFeature( Window.FEATURE_NO_TITLE )
            dialog!!.setContentView( R.layout.dialog_progress_bar )
            dialog!!.window!!.setBackgroundDrawableResource( android.R.color.transparent )
            dialog!!.window!!.setLayout( WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT )
            dialog!!.setCancelable( false )
        }

        dialog?.show()
        return dialog!!
    }

    fun hide(){
        if( dialog != null && dialog!!.isShowing ){
            dialog!!.dismiss()
        }
    }
}