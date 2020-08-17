package com.moizest89.ionix_test.data.services

import com.moizest89.ionix_test.domain.RutInformationResponse
import com.moizest89.ionix_test.domain.UserInformation
import retrofit2.Call
import retrofit2.http.*

interface IApiService {

    @GET("/test-tecnico/search")
    fun getRutInformation( @Query("rut") rut : String ) : Call< RutInformationResponse >

    @POST
    fun createUser( @Url url: String , @Body userInformation: UserInformation ) : Call< UserInformation >

}