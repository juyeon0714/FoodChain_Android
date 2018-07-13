package com.team.foodchain

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface NetworkService {

    @POST("/users/signup/general")
    fun postSignGeneral(
            @Body postSignupGeneral: PostSignupGeneral
    ): retrofit2.Call<PostSignupGeneralResponse>

    @POST("/users/signup/supplier")
    fun postSignMaster(
            @Body postSignupMaster: PostSignupMaster
    ): retrofit2.Call<PostSignupMasterResponse>

    @POST("/users/choice/set")
    fun postChoice(
            @Header("token") token: String,
            @Body postChoice: PostChoice
    ): retrofit2.Call<PostChoiceResponse>


    @GET("/home/main")
    fun getProduct(token: String): Call<GetProductResponse>

    @GET("/home/category")
    fun getCategory(token:String, pro_cate:String):Call<GetCateResponse>
}