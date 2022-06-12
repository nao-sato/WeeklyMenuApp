package com.example.weeklymenuapp

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.graphics.Path
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
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

    private fun initAnimation() {

        val im: List<View> = listOf(
            binding.apple,
            binding.F1,
            binding.F2,
            binding.F3,
            binding.F4,
            binding.phone
        )

        val startAnim = MainAnimation(im[0],im[1],im[2],im[3],im[4],im[5])

        AnimatorSet().apply {
            play(startAnim.animSet)
            start()
        }
    }
}






