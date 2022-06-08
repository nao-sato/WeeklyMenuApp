package com.example.weeklymenuapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
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

        val imageList : List<View> = listOf(
            binding.apple,
            binding.F1,
            binding.F2,
            binding.F3,
            binding.F4
        )

        val animList : List<Int> = listOf(
            R.anim.anim_apple1,
            R.anim.anim_foods1,
            R.anim.anim_foods2,
            R.anim.anim_foods3,
            R.anim.anim_foods4
        )

        setAnim(imageList[0],R.anim.anim_apple1)

        for (i in 1..4){
            setAnim(imageList[i],animList[i])
        }
    }

    private fun setAnim(image:View, anim:Int){
        image.startAnimation(AnimationUtils.loadAnimation(this, anim))
    }


}


