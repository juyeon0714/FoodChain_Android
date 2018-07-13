package com.team.foodchain

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_store.view.*

class StoreTab : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater!!.inflate(R.layout.fragment_store, container, false)
        //addFragment(StoreSecondTab())

        Log.v("Store", "Store")
        v.store_tab.addTab(v.store_tab.newTab().setText("홈"))
        v.store_tab.addTab(v.store_tab.newTab().setText("타임 세일"))
        v.store_tab.addTab(v.store_tab.newTab().setText("주변 마켓"))
        ///탭 만들기


        var storeAdapter = StoreAdapter(activity!!.supportFragmentManager, v.store_tab.tabCount)
        //어댑터 만들기.
        val storeViewpager = v.findViewById<CustomViewPager>(R.id.store_viewpager)

        storeViewpager.adapter = storeAdapter
        storeViewpager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(v.store_tab))
        //탭을 안 쓰는 뷰페이저의 경우 괄호(TabLayout.~~~~) 부분이 바뀌어야 함.

        ///위에까지가 페이지 전환 관련////

        v.store_tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                storeViewpager.currentItem = tab!!.position
            }

        })

        ///이 위는 탭 선택


        return v
    }

//    fun onClick(v: View?) {
//        when(v){
//            bottombar_search -> {
//                clearSelected()
//                bottombar_search.isSelected = true
//                replaceFragment(검색())
//            }
//            bottombar_cart -> {
//                clearSelected()
//                bottombar_cart.isSelected = true
//                replaceFragment(장바구니())
//            }
//        }
//    }
}
//
//fun addFragment(fragment : Fragment){
//    val fm = supportFragmentManager
//    val transaction = fm.beginTransaction()
//    transaction.add(R.id.main_frame, fragment)
//    transaction.commit()
//}
//
//fun replaceFragment(fragment: Fragment){
//    val fm = supportFragmentManager
//    val transaction = fm.beginTransaction()
//    transaction.replace(R.id.main_frame, fragment)
//    transaction.addToBackStack(null)
//    transaction.commit()
//}
//
//fun clearSelected(){
//    bottombar_cart.isSelected = false
//    bottombar_search.isSelected = false
//}