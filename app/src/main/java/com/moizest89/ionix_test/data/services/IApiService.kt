package com.moizest89.ionix_test.data.services

import com.moizest89.ionix_test.domain.RutInformationResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IApiService {

    @GET("/test-tecnico/search")
    fun getRutInformation( @Query("rut") rut : String ) : Call< RutInformationResponse >
}