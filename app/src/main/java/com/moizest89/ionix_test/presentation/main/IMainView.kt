package com.moizest89.ionix_test.presentation.main

import com.moizest89.ionix_test.domain.Item
import com.moizest89.ionix_test.domain.UserInformation

interface IMainView {

    fun getRutNumberInformation()
    fun searchRutInformation( rutNumber : String )
    fun showSandboxItemInformation( item : Item? )
    fun showErrorMessage( error : Throwable? )
    fun createUser()
    fun showUserInformation( userInformation: UserInformation? )
}