package com.team.foodchain

import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_address.*

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
                    setContentView(R.layout.frame_address2)
//            root_layout.setBackgroundColor(Color.TRANSPARENT)
                }

                builder.setNeutralButton("입장하기") { dialog, which ->
                    setContentView(R.layout.frame_main)
//            root_layout.setBackgroundColor(Color.TRANSPARENT)
                }

                val dialog: AlertDialog = builder.create()

                dialog.show()
            }
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



    }

