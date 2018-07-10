package com.team.foodchain

import android.nfc.Tag
import android.os.Bundle
import alondroid.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import android.widget.LinearLayout
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.product_item.*

class productActivity :AppCompatActivity(){

    private val TAG = "productActivity"
    private val NUM_COLUMNS = 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_item)

        var mNames=ArrayList<String>()
        var mImageUrls=ArrayList<String>()

        // Put some user's in users list
         fun initImageBitmaps() {
            Log.d(TAG, "initImageBitmaps:preparing bitmaps")

            mImageUrls.add("@drawable/full_heart")
            mNames.add("케냐산 원두")

            mImageUrls.add("@drawable/full_heart")
            mNames.add("케냐산 원두")

            mImageUrls.add("@drawable/full_heart")
            mNames.add("케냐산 원두")

            mImageUrls.add("@drawable/full_heart")
            mNames.add("케냐산 원두")
        }


        // Initialize a new linea r layout manager
//        var linearLayoutManager : LinearLayoutManager = LinearLayoutManager(
//                this, // Context
//                LinearLayout.VERTICAL, // Orientation
//                false // Reverse layout
//        )
//
//        // Specify the layout manager for recycler view
//        recycler_view.layoutManager = linearLayoutManager
//
//        // Finally, data bind the recycler view with adapter
//        recycler_view.adapter = RecyclerViewAdapter(users)
//    }
        fun initRecyclerView() {
             Log.d(TAG, "initRecyclerView:initializing staggered recyclerview")
            val recyclerView = findViewById(R.id.recycler_View)
            val staggeredRecyclerViewAdapter = StaggeredRecyclerViewAdapter(this, mNames, mImageUrls)
            val staggeredGridLayoutManager  = StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.VERTICAL)
            recyclerView.setLayoutManager(staggeredGridLayoutManager)
            recyclerView.setAdapter(staggeredRecyclerViewAdapter)
    }

}

