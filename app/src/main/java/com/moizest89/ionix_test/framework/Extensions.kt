package com.moizest89.ionix_test.framework

import android.text.Editable
import android.text.TextWatcher
import android.util.Base64
import com.google.android.material.textfield.TextInputEditText
import java.security.Security
import javax.crypto.Cipher
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.DESKeySpec
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec


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


fun String.toDESEncrypt( password : String = "ionix123456" ) : String{
    val keySpec = DESKeySpec( password.toByteArray( Charsets.UTF_8 ) )
    val keyFactory: SecretKeyFactory = SecretKeyFactory.getInstance("DES")
    val cleartext: ByteArray = this.toByteArray( Charsets.UTF_8 )
    val cipher: Cipher = Cipher.getInstance("DES")
    return Base64.encodeToString( cipher.doFinal( cleartext ), Base64.DEFAULT )
}


fun String.encrypt(password: String = "ionix123456" ): String {
    val secretKeySpec = SecretKeySpec(password.toByteArray(), "AES")
    val iv = ByteArray(16)
    val charArray = password.toCharArray()
    for (i in 0 until charArray.size){
        iv[i] = charArray[i].toByte()
    }
    val ivParameterSpec = IvParameterSpec(iv)

    val cipher = Cipher.getInstance("AES/GCM/NoPadding")
    cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec)

    val encryptedValue = cipher.doFinal(this.toByteArray())
    return Base64.encodeToString(encryptedValue, Base64.DEFAULT)
}

