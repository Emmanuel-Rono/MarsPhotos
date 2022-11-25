package com.example.marsphotos.networkLayer

import com.squareup.moshi.Json

data class marsPhotoResponse(
    val id :String,
    //kotlin don't use _ for decleration
    //SO we pass This to
    @Json(name = "img_src") val imgSrcUrl: String

)