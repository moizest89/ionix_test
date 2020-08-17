package com.moizest89.ionix_test.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.moizest89.ionix_test.data.repository.SandboxRepository
import com.moizest89.ionix_test.domain.RutInformationResponse
import com.moizest89.ionix_test.framework.LiveDataResource

class MainViewModel( private val repository : SandboxRepository) : ViewModel() {

    private val mRutInformation = MutableLiveData<LiveDataResource<RutInformationResponse>>()

    fun searchRutInformation( rut : String ) : MutableLiveData<LiveDataResource<RutInformationResponse>>{
        this.mRutInformation.value = LiveDataResource.Loading()
        this.repository.searchRutInformation( rut , {
            this.mRutInformation.value = LiveDataResource.Success( it )
        } ,{
            this.mRutInformation.value = LiveDataResource.Failure( it )
        })
        return mRutInformation
    }

}