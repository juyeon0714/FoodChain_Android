package com.team.foodchain

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

// 1
class PagerAdapter(val photos: ArrayList<Photos>, fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return RecFragment.newInstance(position, photos)
    }

    // 3
    override fun getCount(): Int = photos.size

}