package com.example.weeklymenuapp

import android.animation.AnimatorSet
import android.os.Bundle
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

        val animatorSet = AnimatorSet()

        val setImage = MainAnimation(
            binding.apple,
            binding.F1,
            binding.F2,
            binding.F3,
            binding.F4,
            binding.phone,
            binding.greet,
            binding.menuBottomNav,
        )

        animatorSet.playSequentially(setImage.animList)
        animatorSet.start()
    }
}






