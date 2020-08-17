package com.moizest89.ionix_test.data.repository

import android.content.Context
import com.moizest89.ionix_test.data.services.ApiService
import com.moizest89.ionix_test.domain.RutInformationResponse
import com.moizest89.ionix_test.framework.Util
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SandboxRepository( val context: Context , val apiService : ApiService ) : ISandbox{


    override fun searchRutInformation( rutNumber: String, onSuccess: (RutInformationResponse) -> Unit, onError: (Throwable) -> Unit) {

        ApiService.getService().getRutInformation( Util.encrypt( rutNumber ) ).enqueue( object : Callback<RutInformationResponse>{
            override fun onFailure(call: Call<RutInformationResponse>, t: Throwable) {
                onError.invoke( t )
            }
            override fun onResponse( call: Call<RutInformationResponse>, response: Response<RutInformationResponse>) {
                if( response.isSuccessful ){
                    onSuccess.invoke( response.body()!! )
                }else{
                    onError.invoke( Throwable( message = "response error ${response.code()}") )
                }
            }
        })

    }

}