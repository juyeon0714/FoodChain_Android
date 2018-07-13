package com.team.foodchain

import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_address.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//var isLocate = 0

class AddressActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
//        when(v){
//            ->{
//                setContentView(R.layout.frame_address2)
//            }
//        }
        when(v){
            address_location_btn -> {
                val builder = AlertDialog.Builder(this@AddressActivity)

                builder.setMessage("우리 동네에 입장하시겠어요?")
                builder.setPositiveButton("취소") { dialog, which ->
                    setContentView(R.layout.frame_address1)
//            root_layout.setBackgroundColor(Color.TRANSPARENT)
                }

                builder.setNeutralButton("입장하기") { dialog, which ->
                    //setContentView(R.layout.frame_main)
//            root_layout.setBackgroundColor(Color.TRANSPARENT)
                }

                val dialog: AlertDialog = builder.create()

                dialog.show()
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address)
        addFragment(Address1())
        lateinit var networkService2 : NetworkService2
        val retrofit = Retrofit.Builder()
                .baseUrl("http://www.juso.go.kr")
               // .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        address_location_btn.setOnClickListener(this)

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {

        } else {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 0)
            finish()
        }
    }



fun addFragment(fragment : Fragment){
    val fm = supportFragmentManager
    val transaction = fm.beginTransaction()
    transaction.add(R.id.address_frame, fragment)
    transaction.commit()
}

fun replaceFragment(fragment: Fragment){
    val fm = supportFragmentManager
    val transaction = fm.beginTransaction()
    transaction.replace(R.id.address_frame, fragment)
    transaction.addToBackStack(null)
    transaction.commit()
}

}
//        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
//                == PackageManager.PERMISSION_GRANTED) {
//            isLocate = 1
//        } else {
//            isLocate = 0
//            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 0)
//            finish()
//        }





