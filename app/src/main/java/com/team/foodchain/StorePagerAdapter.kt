package com.team.foodchain

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import com.bumptech.glide.Glide

class StorePagerAdapter(var pro_idx : ArrayList<Reco>, var pro_img : Context): PagerAdapter() {

    lateinit var layoutInflater : LayoutInflater

    init {
        layoutInflater = pro_img.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun isViewFromObject(view: View, any: Any): Boolean {
        return view == (any as LinearLayout)
    }

    override fun getCount(): Int = pro_idx.size

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemView = layoutInflater.inflate(R.layout.storepager_item, container, false)

        var image = itemView.findViewById<ImageView>(R.id.spager_image)
        Glide.with(pro_img).load(pro_idx[position].pro_img).into(image)

        container.addView(itemView)
        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, any: Any) {
        container.removeView((any as LinearLayout))
    }


}

