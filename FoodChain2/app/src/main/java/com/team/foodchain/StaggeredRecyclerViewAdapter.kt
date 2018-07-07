package com.team.foodchain

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.layout_grid_item.view.*

 class StaggeredRecyclerViewAdapter(val context : Context, val mNames : ArrayList<String>, val mImageUrls:ArrayList<String>) : RecyclerView.Adapter<ViewHolder>() {

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return mImageUrls.size
    }

    // Inflates the item views
    fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.layout_grid_item, parent, false))
    }

    // Binds each animal in the ArrayList to a view
//    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
//        holder?.imageType?.text = mImageUrls.get(position)
//    }
    override fun onBindViewHolder(holder:ViewHolder?, position:Int) {
        Log.d(TAG, "onBindViewHolder:called")
        val requestOptions = RequestOptions()
                .placeholder(R.drawable.full_heart)

        Glide.with(context)
                .load(mImageUrls.get(position))
                .apply(requestOptions)
                .into(holder.imageType)


        holder?.nameType?.setText(mNames.get(position))
        holder?.imageType?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View){
                Log.d(TAG, "onClick:clicked on:" + mNames.get(position))
                Toast.makeText(context, mNames.get(position), Toast.LENGTH_SHORT).show()
            }
        }
        }
 }
/////////////////////
class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each animal to
    val nameType = view.name_widget
    val imageType = view.imageview_widget
  }