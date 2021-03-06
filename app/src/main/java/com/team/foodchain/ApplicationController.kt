package com.team.foodchain

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApplicationController : Application() {
    lateinit var networkSerVice : NetworkService
    private val baseUrl = "https://www.eatda.cf"
    companion object{
        lateinit var instance : ApplicationController
        //일종의 스태틱
    }


    override fun onCreate() {
        super.onCreate()
        instance = this
        buildNetwork()
    }

    fun buildNetwork(){
        val builder = Retrofit.Builder()
        val retrofit = builder
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        networkSerVice = retrofit.create(NetworkService::class.java)
    }

}