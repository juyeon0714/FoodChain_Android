package com.team.foodchain

import android.content.Context
import android.support.v4.view.MotionEventCompat
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

class CustomViewPager : ViewPager {

    var scrollable : Boolean = false

    constructor(context : Context) : super(context)
    constructor(context : Context, attributeSet: AttributeSet) : super(context, attributeSet)

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        if(scrollable){
            return super.onInterceptTouchEvent(ev)
        }else{
            if(MotionEventCompat.getActionMasked(ev) == MotionEvent.ACTION_MOVE){

            }else{
                if(super.onInterceptTouchEvent(ev)){
                    super.onTouchEvent(ev)
                }
            }
            return false;
        }
    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        if(scrollable){
            return super.onTouchEvent(ev)
        }else{
            return MotionEventCompat.getActionMasked(ev) != MotionEvent.ACTION_MOVE && super.onTouchEvent(ev)
        }
    }

    fun setPagionEnabled(scrollable : Boolean){
        this.scrollable = scrollable
    }

}