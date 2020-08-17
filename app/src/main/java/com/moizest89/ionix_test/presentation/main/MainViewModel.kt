package com.moizest89.ionix_test.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.moizest89.ionix_test.data.repository.SandboxRepository
import com.moizest89.ionix_test.domain.RutInformationResponse
import com.moizest89.ionix_test.domain.UserInformation
import com.moizest89.ionix_test.framework.LiveDataResource

class MainViewModel( private val repository : SandboxRepository) : ViewModel() {

    private val mRutInformation = MutableLiveData<LiveDataResource<RutInformationResponse>>()
    private val mUserInformation = MutableLiveData< LiveDataResource<UserInformation> >()


    fun searchRutInformation( rut : String ) : MutableLiveData<LiveDataResource<RutInformationResponse>>{
        this.mRutInformation.value = LiveDataResource.Loading()
        this.repository.searchRutInformation( rut , {
            this.mRutInformation.value = LiveDataResource.Success( it )
        } ,{
            this.mRutInformation.value = LiveDataResource.Failure( it )
        })
        return mRutInformation
    }

    fun createUserInformation() : MutableLiveData< LiveDataResource<UserInformation> >{

        this.mUserInformation.value = LiveDataResource.Loading()
        this.repository.createUser(
            onSuccess = {
                this.mUserInformation.value = LiveDataResource.Success( it )
            } ,
            onError = {
                this.mUserInformation.value = LiveDataResource.Failure( it )
            })
        return mUserInformation
    }

}