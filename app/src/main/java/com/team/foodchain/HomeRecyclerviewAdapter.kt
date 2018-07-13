package com.team.foodchain

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.RequestManager

class HomeRecyclerviewAdapter(var productItems : ArrayList<Data>, var requestManager : RequestManager)  : RecyclerView.Adapter<ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val mainView : View = LayoutInflater.from(parent.context)
                .inflate(R.layout.rec_item, parent, false)
        return ProductViewHolder(mainView)
    }

    override fun getItemCount(): Int  = productItems.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.productId.text = productItems[position].pro_name
       // holder.productPercent.text = productItems[position].product_percent
        holder.productSalePrice.text = productItems[position].pro_sale_price
        holder.productOriginalPrice.text = productItems[position].pro_price
        requestManager.load(productItems[position].pro_img).into(holder.productProfile )

    }
}
