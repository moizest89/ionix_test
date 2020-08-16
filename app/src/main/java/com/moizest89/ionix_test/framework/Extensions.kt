package com.moizest89.ionix_test.framework

import android.text.Editable
import android.text.TextWatcher
import com.google.android.material.textfield.TextInputEditText


fun TextInputEditText.setMask( mask : String ) : TextInputEditText{
    var isRunning = false
    var isDeleting = false

    this.addTextChangedListener( object : TextWatcher{
        override fun afterTextChanged( editable: Editable) {
            if( mask.isBlank() ) return
            if (isRunning || isDeleting) {
                return
            }
            isRunning = true
            val editableLength: Int = editable.length
            if (editableLength < mask.length) {
                if (mask[editableLength] != '#') {
                    editable.append( mask[ editableLength ] )
                } else if ( mask[editableLength - 1] != '#' ) {
                    editable.insert(editableLength - 1, mask, editableLength - 1, editableLength)
                }
            }
            isRunning = false
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

    })

    return this@setMask

}