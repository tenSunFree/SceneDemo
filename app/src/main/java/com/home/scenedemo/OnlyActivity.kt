package com.home.scenedemo

import com.bytedance.scene.Scene
import com.bytedance.scene.ui.SceneActivity
import com.home.scenedemo.splash.SplashScene

class OnlyActivity : SceneActivity() {

    override fun getHomeSceneClass(): Class<out Scene> {
        return SplashScene::class.java
    }

    override fun supportRestore(): Boolean {
        return true
    }
}