package com.moizest89.ionix_test.presentation.main

import com.moizest89.ionix_test.domain.Item

interface IMainView {

    fun getRutNumberInformation()
    fun searchRutInformation( rutNumber : String )
    fun showSandboxItemInformation( item : Item? )
    fun showErrorMessage( error : Throwable? )

}