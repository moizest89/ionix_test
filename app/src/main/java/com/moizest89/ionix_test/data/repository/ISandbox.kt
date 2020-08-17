package com.moizest89.ionix_test.data.repository

import com.moizest89.ionix_test.domain.RutInformationResponse
import com.moizest89.ionix_test.domain.UserInformation

interface ISandbox {


    fun searchRutInformation( rutNumber : String , onSuccess : (RutInformationResponse) -> Unit , onError : ( Throwable ) -> Unit )

    fun createUser(  onSuccess : ( UserInformation ) -> Unit , onError : ( Throwable ) -> Unit )

}