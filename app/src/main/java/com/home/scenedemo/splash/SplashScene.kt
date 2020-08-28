package com.home.scenedemo.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bytedance.scene.Scene
import com.bytedance.scene.interfaces.PushOptions
import com.home.scenedemo.main.MainScene
import com.home.scenedemo.R

class SplashScene : Scene() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup, savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(
            R.layout.scene_splash, container, false
        ) as View
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        jumpMainScene()
    }

    private fun jumpMainScene() {
        view.postDelayed({
            val enterAnim = R.anim.slide_in_from_right
            val exitAnim = R.anim.slide_out_to_left
            navigationScene?.push(
                MainScene::class.java, null,
                PushOptions.Builder()
                    .setAnimation(requireActivity(), enterAnim, exitAnim)
                    .clearCurrent().build()
            )
        }, 2500)
    }
}
