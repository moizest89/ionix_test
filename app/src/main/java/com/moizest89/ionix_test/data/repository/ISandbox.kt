package com.moizest89.ionix_test.data.repository

import com.moizest89.ionix_test.domain.RutInformationResponse

interface ISandbox {


    fun searchRutInformation( rutNumber : String , onSuccess : (RutInformationResponse) -> Unit , onError : ( Throwable ) -> Unit )

}