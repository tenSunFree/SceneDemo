package com.home.scenedemo.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bytedance.scene.Scene
import com.home.scenedemo.R

class MainDiscountScene : Scene() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup, savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(
            R.layout.scene_main_discount, container, false
        ) as View
    }

    companion object {
        fun newInstance(name: String): MainDiscountScene {
            val scene = MainDiscountScene()
            val bundle = Bundle()
            bundle.putString("name", name)
            scene.setArguments(bundle)
            return scene
        }
    }
}