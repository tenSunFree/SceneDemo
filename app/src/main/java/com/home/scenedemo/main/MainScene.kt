package com.home.scenedemo.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bytedance.scene.group.GroupScene
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.home.scenedemo.R

class MainScene : GroupScene() {

    lateinit var mainHomeScene: MainHomeScene
    lateinit var mainDiscountScene: MainDiscountScene
    lateinit var mainParkingScene: MainParkingScene
    lateinit var mainMineScene: MainMineScene

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup, savedInstanceState: Bundle?
    ): ViewGroup {
        return inflater.inflate(
            R.layout.scene_main, container, false
        ) as ViewGroup
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initScene()
        initBottomNavigationView()
    }

    private fun initScene() {
        mainHomeScene = createOrReuse("home") {
            MainHomeScene.newInstance("home")
        }
        mainDiscountScene = createOrReuse("discount") {
            MainDiscountScene.newInstance("discount")
        }
        mainParkingScene = createOrReuse("parking") {
            MainParkingScene.newInstance("parking")
        }
        mainMineScene = createOrReuse("mine") {
            MainMineScene.newInstance("mine")
        }
        if (!isAdded(mainHomeScene)) add(R.id.frame_layout, mainHomeScene, "home")
        if (!isAdded(mainDiscountScene)) add(R.id.frame_layout, mainDiscountScene, "discount")
        if (!isAdded(mainParkingScene)) add(R.id.frame_layout, mainParkingScene, "parking")
        if (!isAdded(mainMineScene)) add(R.id.frame_layout, mainMineScene, "mine")
        hideScene()
        show(mainHomeScene, R.anim.slide_in_from_right)
    }

    private fun initBottomNavigationView() {
        requireViewById<BottomNavigationView>(R.id.bottom_navigation_view)
            .setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.item_home -> {
                        hideScene()
                        show(mainHomeScene, R.anim.slide_in_from_right)
                        return@setOnNavigationItemSelectedListener true
                    }
                    R.id.item_discount -> {
                        hideScene()
                        show(mainDiscountScene, R.anim.slide_in_from_right)
                        return@setOnNavigationItemSelectedListener true
                    }
                    R.id.item_parking -> {
                        hideScene()
                        show(mainParkingScene, R.anim.slide_in_from_right)
                        return@setOnNavigationItemSelectedListener true
                    }
                    R.id.item_mine -> {
                        hideScene()
                        show(mainMineScene, R.anim.slide_in_from_right)
                        return@setOnNavigationItemSelectedListener true
                    }
                }
                false
            }
    }

    private fun hideScene() {
        hide(mainHomeScene, R.anim.slide_out_to_left)
        hide(mainDiscountScene, R.anim.slide_out_to_left)
        hide(mainParkingScene, R.anim.slide_out_to_left)
        hide(mainMineScene, R.anim.slide_out_to_left)
    }
}
