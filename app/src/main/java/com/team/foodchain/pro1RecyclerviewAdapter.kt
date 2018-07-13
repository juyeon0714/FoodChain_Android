package com.team.foodchain

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.RequestManager

class pro1RecyclerviewAdapter(var vegeItems : ArrayList<GetVegeResponseData>, var requestManager : RequestManager)  : RecyclerView.Adapter<VegeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):VegeViewHolder {
        val mainView : View = LayoutInflater.from(parent.context)
                .inflate(R.layout.menu1, parent, false)
        return VegeViewHolder(mainView)
    }

    override fun getItemCount(): Int  = vegeItems.size

    override fun onBindViewHolder(holder: VegeViewHolder, position: Int) {
        holder.vegeId.text = vegeItems[position].vege_name
        holder.vegePercent.text = vegeItems[position].vege_percent
        holder.vegeSalePrice.text = vegeItems[position].vege_saleprice
        holder.vegeOriginalPrice.text =vegeItems[position].vege_original
        holder.vegeDistance.text=vegeItems[position].vege_distance
        requestManager.load(vegeItems[position].vegeImage).into(holder.vegeProfile )

    }
}
