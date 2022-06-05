package com.example.weeklymenuapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import com.example.weeklymenuapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialize()
    }

    private fun initialize(){
        initBinding()
        initAnimation()
    }

    private fun initBinding(){
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    private fun initAnimation(){

        binding.apple.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_apple1))

        binding.F1.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_foods1))

        binding.F2.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_foods2))

        binding.F3.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_foods3))

        binding.F4.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_foods4))
    }
}


