package com.team.foodchain

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_choice.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

var isFirst = 0


class ChoiceActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var pro_cate : ArrayList<String>
    var flag = 0


    override fun onClick(v: View?) {
        when(v){
            category0_a-> {
                category0_a.isSelected = true
                pro_cate.add("0_a")
            }
            category0_b -> {
                category0_a.isSelected = true
                pro_cate.add("0_b")
            }
            category1_a -> {
                category1_a.isSelected = true
                pro_cate.add("1_a")
            }
            category1_b -> {
                category1_b.isSelected = true
                pro_cate.add("1_b")
            }
            category1_c -> {
                category1_c.isSelected = true
                pro_cate.add("1_c")
            }
            category1_d -> {
                category1_d.isSelected = true
                pro_cate.add("1_d")
            }
            category1_e -> {
                category1_e.isSelected = true
                pro_cate.add("1_e")
            }
            category2 -> {
                category2.isSelected = true
                pro_cate.add("2")
            }
            category3_a -> {
                category3_a.isSelected = true
                pro_cate.add("3_a")
            }
            category3_b -> {
                category3_b.isSelected = true
                pro_cate.add("3_b")
            }
            category3_c -> {
                category3_c.isSelected = true
                pro_cate.add("3_c")
            }
            category3_d -> {
                category3_d.isSelected = true
                pro_cate.add("3_d")
            }
            category3_e ->{
                category3_e.isSelected = true
                pro_cate.add("3_e")
            }
            category4 -> {
                category4.isSelected = true
                pro_cate.add("4")
            }
            category5_a -> {
                category5_a.isSelected = true
                pro_cate.add("5_a")
            }
            category5_b -> {
                category5_b.isSelected = true
                pro_cate.add("5_b")
            }
            category6_a -> {
                category6_a.isSelected = true
                pro_cate.add("6_a")
            }
            category6_b -> {
                category6_b.isSelected = true
                pro_cate.add("6_b")
            }
            category6_c -> {
                category6_c.isSelected = true
                pro_cate.add("6_c")
            }
            category6_d -> {
                category6_d.isSelected = true
                pro_cate.add("6_d")
            }
            category6_e -> {
                category6_e.isSelected = true
                pro_cate.add("6_e")
            }
            category6_f -> {
                category6_f.isSelected = true
                pro_cate.add("6_f")
            }
            category7_a -> {
                category7_a.isSelected = true
                pro_cate.add("7_a")
            }
            category7_b ->{
                category7_b.isSelected = true
                pro_cate.add("7_b")
            }

        }
    }

    lateinit var networkService: NetworkService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice)
        pro_cate = ArrayList<String>()
        category0_a.setOnClickListener(this)
        category0_b.setOnClickListener(this)
        category1_a.setOnClickListener(this)
        category1_b.setOnClickListener(this)
        category1_c.setOnClickListener(this)
        category1_d.setOnClickListener(this)
        category1_e.setOnClickListener(this)
        category2.setOnClickListener(this)
        category3_a.setOnClickListener(this)
        category3_b.setOnClickListener(this)
        category3_c.setOnClickListener(this)
        category3_d.setOnClickListener(this)
        category3_e.setOnClickListener(this)
        category4.setOnClickListener(this)
        category5_a.setOnClickListener(this)
        category5_b.setOnClickListener(this)
        category6_a.setOnClickListener(this)
        category6_b.setOnClickListener(this)
        category6_c.setOnClickListener(this)
        category6_d.setOnClickListener(this)
        category6_e.setOnClickListener(this)
        category6_f.setOnClickListener(this)
        category7_a.setOnClickListener(this)
        category7_b.setOnClickListener(this)

        isFirst = 1
        networkService = ApplicationController.instance.networkSerVice


        choice_confirm_tv.setOnClickListener{
            postChoice(pro_cate)
        }
    }

    fun postChoice(pro_cate : ArrayList<String>){

        val postChoice = PostChoice(pro_cate)

        val postChoiceResponse = networkService.postChoice("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6ImdvZXVuQGdtYWlsLmNvbSIsInB3IjoiK1JkYTJlK2FTcE9kK1Aya0t0L2h6aDl2V1JLRm0vb0g3bll2UkhRbjVmND0iLCJpZGVudGlmeSI6MCwiaWF0IjoxNTMxMzA0NjYzfQ.IieKd7HDJJGEMuLHKDdyZ-PwilWlzq58iNX8mkDbNAo",postChoice)
        postChoiceResponse.enqueue(object : Callback<PostChoiceResponse> {
            override fun onResponse(call: Call<PostChoiceResponse>?, response: Response<PostChoiceResponse>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onFailure(call: Call<PostChoiceResponse>?, t: Throwable?) {
                Log.v("text", t.toString())
            }

//            override fun onResponse(call: Call<PostChoiceResponse>?, response: GetRecentContextCall.Response<PostChoiceResponse>?) {
//                if(response!!.isSuccessful){
//                    val intent = Intent(applicationContext, HomeActivity::class.java)
//                    startActivity(intent)
//                }
//            }
        })
    }

}