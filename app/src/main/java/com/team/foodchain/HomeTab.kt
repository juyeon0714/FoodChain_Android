package com.team.foodchain

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.team.foodchain.RecFragment.Companion.photos
import kotlinx.android.synthetic.main.store_home_tab.*
import kotlinx.android.synthetic.main.store_home_tab.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeTab : Fragment() {
    lateinit var pro_idx : ArrayList<Reco>
    lateinit var networkService : NetworkService
    lateinit var storePagerAdapter : StorePagerAdapter
    lateinit var requestManager : RequestManager
    lateinit var pro_img:ArrayList<Reco>

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.store_home_tab)
        networkService = ApplicationController.instance.networkSerVice
        requestManager=Glide.with(this)
       main_product_list.layoutManager=LinearLayoutManager(this)
        //클릭하면 상품정보 볼수있게.setOnClickListener{
        //  startActivity(Intent(applicationContext, BoardActivity::class.java))


    val getProductResponse = networkService.getProduct("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6ImxzbTAzNDF6ekBnbWFpbC5jb20iLCJwdyI6IkVaZno3aTl5M3R3QWY3SE1XSVF5cG82dmFuMEJOWkJnQk9rcGJJZ3ovblU9IiwiaWRlbn" +
        "RpZnkiOjAsImlhdCI6MTUzMTQ3ODM3MH0.SCtkpHq5yRJ8rfuuQPTqa1Lp__SJDyhAwby-4DMxoIo")
getProductResponse.enqueue(object : Callback<GetProductResponse> {
    override fun onFailure(call: Call<GetProductResponse>?, t: Throwable?) {

    }

    override fun onResponse(call: Call<GetProductResponse>?, response: Response<GetProductResponse>?) {
        if (response!!.isSuccessful) {
            pro_idx = response.body().reco
            Log.e("a", response.body().reco.toString())
            var storePagerAdapter = StorePagerAdapter(pro_idx, pro_img!!)
            v.home_recommend_vp.adapter = storePagerAdapter
        }
    }
}
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater!!.inflate(R.layout.store_home_tab, container, false)
        //addFragment(StoreSecondTab())

        pro_idx = ArrayList()

        v.home_recommend_vp.adapter = StorePagerAdapter(pro_idx, context!!)

        return v
    }

