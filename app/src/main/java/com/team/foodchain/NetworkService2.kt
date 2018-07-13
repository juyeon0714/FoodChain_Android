package com.team.foodchain


import retrofit2.http.Body
import retrofit2.http.POST


interface NetworkService2 {

    @POST("/addrlink/addrLinkApi.do")
    fun postSearchLocation(
            @Body postSearchLocation: PostSearchLocation
    ) : retrofit2.Call<PostSearchLocationResponse>

}
