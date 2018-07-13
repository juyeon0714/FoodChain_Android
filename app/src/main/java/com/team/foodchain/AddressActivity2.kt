package com.team.foodchain

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_address2.*


class AddressActivity2 : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when(v){
            address_continue_btn -> {
                val intent = Intent(applicationContext, HomeActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address2)
        addFragment(Map())
        address_continue_btn.setOnClickListener(this)
    }

    fun addFragment(fragment : Fragment){
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        transaction.add(R.id.map_frame, fragment)
        transaction.commit()
    }
}
