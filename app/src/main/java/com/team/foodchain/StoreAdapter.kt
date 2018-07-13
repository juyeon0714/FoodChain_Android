package com.team.foodchain

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentStatePagerAdapter

class StoreAdapter(fm : android.support.v4.app.FragmentManager?) : FragmentStatePagerAdapter(fm) {


    var tabCount : Int = 0
    var homeTab : HomeTab? = null
    var timesaleTab : TimeSaleTab? = null
    var aroundMarketFragment : AroundMarketFragment? = null

    override fun getItem(position: Int): Fragment? {
        when(position){
            0->{
                return homeTab!!
            }
            1->{
                return timesaleTab!!
            }
            2->{
                return aroundMarketFragment!!
            }
        }
        return null
    }

    override fun getCount(): Int = this.tabCount

    constructor(fm : android.support.v4.app.FragmentManager, tabCount : Int) : this(fm){
        this.homeTab = HomeTab()
        this.timesaleTab = TimeSaleTab()
        this.aroundMarketFragment = AroundMarketFragment()
        this.tabCount = tabCount

    }



}