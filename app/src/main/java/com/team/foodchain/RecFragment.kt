package com.team.foodchain


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class RecFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_rec,container,false)
        val position = arguments?.getInt("position",0)
        view.tag = position
        val image = view.findViewById<ImageView>(R.id.imageRec)
        val name = view.findViewById<TextView>(R.id.imageRec_name)

        name.text = photos[position!!].name
        Glide.with(this)
                .load(photos[position!!].path)
                .into(image)
        return view
    }

    companion object {
        val photos=ArrayList<Photos>()
        fun newInstance(position:Int, photos:ArrayList<Photos>):Fragment{
            val fragment= RecFragment()
            val bundle = Bundle()
            bundle.putInt("position", position)
            fragment.arguments=bundle
            return fragment
        }
    }

}
