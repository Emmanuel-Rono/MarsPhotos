package com.example.marsphotos

import com.example.marsphotos.networkLayer.marsPhotoResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET



private val moshi=Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
private val retrofit= Retrofit.Builder()
    //Builder class uses the Builder API to allow defining the URL end point for
    //the HTTP operations and finally build a new Retrofit instance
    .addConverterFactory(MoshiConverterFactory.create())
    .baseUrl(constants.BASE_URL)
    .build()



interface commWithCloud
{
    @GET("photos") //Endpoint is photos ..Request is Get type
   suspend fun getPhotos():List<marsPhotoResponse>
}
//A public Api object that exposes the lazy-initialized Retrofit service
object MarsAPi
{
    val retrofitService:commWithCloud by lazy {

        retrofit.create(commWithCloud::class.java)

    }
}
