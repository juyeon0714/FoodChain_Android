package com.team.foodchain

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import com.google.android.gms.appdatasearch.GetRecentContextCall
import kotlinx.android.synthetic.main.activity_user_join.*

class UserJoinActivity : AppCompatActivity() {

    lateinit var networkService: NetworkService

//    override fun onClick(v: View?) {
//        when(v){
//            user_join_btn -> {
//                val intent = Intent(applicationContext, ChoiceActivity::class.java)
//                startActivity(intent)
//            }
//        }
//    }

    var pwText : EditText? =null
    var pwCheckText : EditText? = null

    var emailCheck : EditText? = null
    var phoneCheck : EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_join)
        networkService = ApplicationController.instance.networkSerVice

        pwText = findViewById(R.id.user_join_pw) as EditText
        pwCheckText = findViewById(R.id.user_join_pwcheck) as EditText

        pwText!!.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s1: Editable?) {
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s1: CharSequence?, start: Int, before: Int, count: Int) {
                pwCheckText!!.addTextChangedListener(object : TextWatcher {
                    override fun afterTextChanged(s2: Editable?) {
                    }
                    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                    }
                    override fun onTextChanged(s2: CharSequence?, start: Int, before: Int, count: Int) {
                        if(s1!!.toString() == s2!!.toString()){
                            user_pw_check.isSelected = true
                        }
                        else{
                            user_pw_check.isSelected = false
                        }
                    }
                })
            }
        })
        emailCheck = findViewById(R.id.user_join_email) as EditText
        emailCheck!!.addTextChangedListener(object : TextWatcher {phoneCheck = findViewById(R.id.user_join_phone) as EditText
            phoneCheck!!.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                }
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                }
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    val postPhoneCheck = PostPhoneCheck(s!!.toString())

                    val postPhoneCheckResponse = networkService.postPhoneCheck(postPhoneCheck)
                    postPhoneCheckResponse.enqueue(object : Callback<PostPhoneCheckResponse>{
                        override fun onFailure(call: Call<PostPhoneCheckResponse>?, t: Throwable?) {
                            user_phone_check.isSelected = false
                        }
                        override fun onResponse(call: Call<PostPhoneCheckResponse>?, response: Response<PostPhoneCheckResponse>?) {
                            if(response!!.isSuccessful){
                                user_phone_check.isSelected = true
                            }
                        }
                    })
                }
            })




       user_join_btn.setOnClickListener{
            postUserSignup()
        }
    }}

    fun postUserSignup(){
        val user_pw_check =  user_join_pwcheck.text.toString()
        val user_pw = user_join_pw.text.toString()
        val user_name = user_join_name.text.toString()
        val user_email = user_join_email.text.toString()
        val user_phone = user_join_phone.text.toString()
        val user_id : String? = null

        val postSignupGeneral = PostSignupGeneral(user_pw_check, user_pw, user_name, user_email, user_phone, user_id)

        val postSignupGeneralResponse = networkService.postSignGeneral(postSignupGeneral)
        postSignupGeneralResponse.enqueue(object : Callback<PostSignupGeneralResponse>{
            override fun onFailure(call: retrofit2.Call<PostSignupGeneralResponse>?, t: Throwable?) {

            }

            override fun onResponse(call: retrofit2.Call<PostSignupGeneralResponse>?, response: GetRecentContextCall.Response<PostSignupGeneralResponse>?) {
                if(response!!.isSuccessful){
                    val intent = Intent(applicationContext, ChoiceActivity::class.java)
                    startActivity(intent)
                }
            }
        })
    }
}