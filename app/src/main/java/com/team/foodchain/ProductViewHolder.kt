package com.team.foodchain

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class ProductViewHolder(itemView : View?) : RecyclerView.ViewHolder(itemView) {
    var productProfile : ImageView = itemView!!.findViewById(R.id.productimage) as ImageView
    var productId : TextView = itemView!!.findViewById(R.id.productname2) as TextView
    var productPercent : TextView = itemView!!.findViewById(R.id.salePercent) as TextView
    var productSalePrice : TextView = itemView!!.findViewById(R.id.salecost) as TextView
    var productOriginalPrice : TextView = itemView!!.findViewById(R.id.originalprice2) as TextView
}