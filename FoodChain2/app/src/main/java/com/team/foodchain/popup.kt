package com.team.foodchain

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.pop_up.*

class popup : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pop_up)

        button.setOnClickListener{
            val builder=AlertDialog.Builder(this@popup)

            builder.setMessage("가입하고 우리 동네 상품을 찾아보세요! " +
                    "우리 동네를 설정하고 시작하세요!")
            builder.setPositiveButton("우리 동네 설정하고 시작하기"){dialog, which->
                setContentView(R.layout.activity_address)
                root_layout.setBackgroundColor(Color.TRANSPARENT)
            }

            builder.setNeutralButton("둘러보기"){dialog,which->
                setContentView(R.layout.activity_basket)
                root_layout.setBackgroundColor(Color.TRANSPARENT)
            }

            val dialog:AlertDialog=builder.create()

            dialog.show()
        }
    }
}