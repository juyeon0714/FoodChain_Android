package com.team.foodchain

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class VegeViewHolder(itemView : View?) : RecyclerView.ViewHolder(itemView) {
    var vegeProfile: ImageView = itemView!!.findViewById(R.id.vegeimage) as ImageView
    var vegeId: TextView = itemView!!.findViewById(R.id.vegename2) as TextView
    var vegePercent: TextView = itemView!!.findViewById(R.id.vegepercent) as TextView
    var vegeSalePrice: TextView = itemView!!.findViewById(R.id.vegesaleprice) as TextView
    var vegeOriginalPrice: TextView = itemView!!.findViewById(R.id.vegeoriginalprice) as TextView
    var vegeDistance: TextView = itemView!!.findViewById(R.id.vegedistance) as TextView
}