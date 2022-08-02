package com.example.weeklymenuapp

import android.animation.AnimatorSet
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
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
//        initBottomNavigation()
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
//            binding.navView,
        )

        animatorSet.playSequentially(setImage.animList)
        animatorSet.start()
    }

//    private fun initBottomNavigation() {
//
//        val navController = findNavController(R.id.nav_host_fragment)
//        val appBarConfiguration = AppBarConfiguration(setOf(
//                R.id.nav_weekly, R.id.nav_recipe, R.id.nav_memo, R.id.nav_search
//            )
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        binding.navView.setupWithNavController(navController)
//    }

}






