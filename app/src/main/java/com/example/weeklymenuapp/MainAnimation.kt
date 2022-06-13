package com.example.weeklymenuapp

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.graphics.Path
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator

class MainAnimation(apple: View, f1: View, f2: View, f3: View, f4: View, phone: View) {



    private val foodAppear = AnimatorSet().apply {
        playTogether(
            Foods(f1).alphaAppear,
            Foods(f2).alphaAppear,
            Foods(f3).alphaAppear,
            Foods(f4).alphaAppear
            )
    }

    private val foodGather = AnimatorSet().apply {
        playTogether(
            Foods(f1).circle,
//            Foods(f2).circle,
//            Foods(f3).circle,
//            Foods(f4).circle,
//            Foods(f1).rotation,
//            Foods(f2).rotation,
//            Foods(f3).rotation,
//            Foods(f4).rotation,
//            Foods(f1).alphaDisappear,
//            Foods(f2).alphaDisappear,
//            Foods(f3).alphaDisappear,
//            Foods(f4).alphaDisappear
        )
    }

    val scaleAllUp = AnimatorSet().apply {
        playTogether(
            Phone(phone).scaleUp_X,
            Phone(phone).scaleUp_Y,
            Apple(apple).scaleUp_X,
            Apple(apple).scaleUp_Y,
            Apple(apple).move_X,
            Apple(apple).move_Y
        )
    }

    var animList = listOf(
        Apple(apple).up,
        Apple(apple).down,
        foodAppear,
        Phone(phone).up,
        foodGather,
//        scaleAllUp
        )


    inner class Apple(image: View) {

        val up : ObjectAnimator = ObjectAnimator.ofFloat(image, "translationY", 500f, -200f).apply {
            duration = 700
            interpolator = DecelerateInterpolator()
        }

        val down : ObjectAnimator = ObjectAnimator.ofFloat(image, "translationY", -200f, 0f).apply {
            duration = 400
            interpolator = AccelerateInterpolator()
        }

        val scaleUp_X : ObjectAnimator = ObjectAnimator.ofFloat(image, "scaleX", 3000F).apply {
            duration = 1500
            interpolator = AccelerateInterpolator()
        }
        val scaleUp_Y : ObjectAnimator = ObjectAnimator.ofFloat(image, "scaleY", 3000F).apply {
            duration = 1500
            interpolator = AccelerateInterpolator()
        }

        val move_X : ObjectAnimator = ObjectAnimator.ofFloat(image, "translationX", 0F, -400f).apply {
            duration = 1500
            interpolator = AccelerateInterpolator()
        }

        val move_Y : ObjectAnimator = ObjectAnimator.ofFloat(image, "translationX", 0F, -400F).apply {
            duration = 1500
            interpolator = AccelerateInterpolator()
        }


    }

    inner class Foods(image: View) {

        private val path = Path().apply {
            arcTo(500f, 500f, 1000f, 1000f, 0f, 150f, true)
        }

        val alphaAppear : ObjectAnimator = ObjectAnimator.ofFloat(image, "alpha", 0f, 1f).apply {
            duration = 2000
        }

        val circle : ObjectAnimator = ObjectAnimator.ofFloat(image, View.X, View.Y, path).apply {
            duration = 1000
        }

        val rotation : ObjectAnimator = ObjectAnimator.ofFloat(image, "rotation", 0f, 150f).apply {
            duration = 1000
        }

        val alphaDisappear : ObjectAnimator = ObjectAnimator.ofFloat(image, "alpha", 1f, 0f).apply {
            duration = 1000
        }
    }

    inner class Phone(image: View) {

        val up : ObjectAnimator = ObjectAnimator.ofFloat(image, "translationY", 1000f, -2000f).apply {
            duration = 1500
            interpolator = DecelerateInterpolator()
        }

        val scaleUp_X : ObjectAnimator = ObjectAnimator.ofFloat(image, "scaleX", 3000F).apply {
            duration = 1500
            interpolator = AccelerateInterpolator()
        }

        val scaleUp_Y : ObjectAnimator = ObjectAnimator.ofFloat(image, "scaleY", 3000F).apply {
            duration = 1500
            interpolator = AccelerateInterpolator()
        }

    }

}