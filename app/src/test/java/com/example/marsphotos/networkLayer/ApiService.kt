package com.example.marsphotos

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private val retrofit= Retrofit.Builder()
    //Builder class uses the Builder API to allow defining the URL end point for
    //the HTTP operations and finally build a new Retrofit instance
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(constants.BASE_URL)
    .build()



interface commWithCloud
{
    @GET("photos") //Endpoint is photos ..Request is Get type
   suspend fun getPhotos():String
}
//A public Api object that exposes the lazy-initialized Retrofit service
object MarsAPi
{
    val retrofitService:commWithCloud by lazy {

        retrofit.create(commWithCloud::class.java)

    }
}
