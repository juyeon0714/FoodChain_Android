package com.team.foodchain

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import kotlinx.android.synthetic.main.appbar_main.*
import kotlinx.android.synthetic.main.frame_main.*


class RecommendActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.frame_main)

        tab_host.setup()

        var spec = tab_host.newTabSpec("1/4")
        spec.setContent(R.id.tab_one)
        spec.setIndicator("1/4")
        tab_host.addTab(spec)

        spec = tab_host.newTabSpec("2/4")
        spec.setContent(R.id.tab_two)
        spec.setIndicator("2/4")
        tab_host.addTab(spec)

        spec = tab_host.newTabSpec("3/4")
        spec.setContent(R.id.tab_three)
        spec.setIndicator("2/4")
        tab_host.addTab(spec)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        var photos = ArrayList<Photos>()
        photos.add(Photos("1/4", "https://pbs.twimg.com/media/DADtsrYXYAAWVue.jpg"))
        photos.add(Photos("2/4", "https://pbs.twimg.com/media/DADtsrYXYAAWVue.jpg"))
        photos.add(Photos("3/4", "https://pbs.twimg.com/media/DADtsrYXYAAWVue.jpg"))
        photos.add(Photos("4/4", "https://pbs.twimg.com/media/DADtsrYXYAAWVue.jpg"))

        home_recommend_vp.adapter = PagerAdapter(photos, supportFragmentManager)
    }
}