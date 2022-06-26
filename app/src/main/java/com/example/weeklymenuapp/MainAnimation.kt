package com.example.weeklymenuapp

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.graphics.Path
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator

class MainAnimation(apple: View, f1: View, f2: View, f3: View, f4: View, phone: View, greet: View) {

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
            Foods(f1).move_X12,
            Foods(f2).move_Y23,
            Foods(f2).move_X12,
            Foods(f3).move_Y23,
            Foods(f3).move_X34,
            Foods(f4).move_X34,
            Foods(f1).rotation,
            Foods(f2).rotation,
            Foods(f3).rotation,
            Foods(f4).rotation,
            Foods(f1).alphaDisappear,
            Foods(f2).alphaDisappear,
            Foods(f3).alphaDisappear,
            Foods(f4).alphaDisappear
        )
    }

    private val scaleAllUp = AnimatorSet().apply {
        playTogether(
            Greet(greet).alphaAppear,
            Phone(phone).scaleUp_X,
            Phone(phone).scaleUp_Y,
            Phone(phone).move_Y,
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
        scaleAllUp
        )


    inner class Apple(image: View) {

        val up : ObjectAnimator = ObjectAnimator.ofFloat(image, "translationY", 500f, -200f).apply {
            duration = 600
            interpolator = DecelerateInterpolator()
        }

        val down : ObjectAnimator = ObjectAnimator.ofFloat(image, "translationY", -200f, 0f).apply {
            duration = 300
            interpolator = AccelerateInterpolator()
        }

        val scaleUp_X : ObjectAnimator = ObjectAnimator.ofFloat(image, "scaleX", 80F).apply {
            duration = 2000
            interpolator = AccelerateInterpolator()
        }
        val scaleUp_Y : ObjectAnimator = ObjectAnimator.ofFloat(image, "scaleY", 80F).apply {
            duration = 2000
            interpolator = AccelerateInterpolator()
        }

        val move_X : ObjectAnimator = ObjectAnimator.ofFloat(image, "translationX", 0F,-2000f).apply {
            duration =600
        }

        val move_Y : ObjectAnimator = ObjectAnimator.ofFloat(image, "translationY", 0F, 2000F).apply {
            duration = 600
        }
    }

    inner class Foods(image: View) {

        val alphaAppear : ObjectAnimator = ObjectAnimator.ofFloat(image, "alpha", 0f, 1f).apply {
            duration = 2000
        }

        val move_X12 : ObjectAnimator = ObjectAnimator.ofFloat(image, "translationX", 0F, 450F).apply {
            duration = 1000
        }

        val move_Y23 : ObjectAnimator = ObjectAnimator.ofFloat(image, "translationY", 0F, 400F).apply {
            duration = 1000
        }

        val move_X34 : ObjectAnimator = ObjectAnimator.ofFloat(image, "translationX", 0F, -450F).apply {
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

        val up : ObjectAnimator = ObjectAnimator.ofFloat(image, "translationY", 600f, -2300f).apply {
            duration = 1000
            interpolator = DecelerateInterpolator()
        }

        val scaleUp_X : ObjectAnimator = ObjectAnimator.ofFloat(image, "scaleX", 80F).apply {
            duration = 3000
            interpolator = AccelerateInterpolator()
        }

        val scaleUp_Y : ObjectAnimator = ObjectAnimator.ofFloat(image, "scaleY", 80F).apply {
            duration = 3000
            interpolator = AccelerateInterpolator()
        }

        val move_Y : ObjectAnimator = ObjectAnimator.ofFloat(image, "translationY", -2300F, -1900f).apply {
            duration = 1000
            interpolator = DecelerateInterpolator()
        }
    }

    inner class Greet(image: View){

        val alphaAppear: ObjectAnimator = ObjectAnimator.ofFloat(image, "alpha", 0F, 1F)
    }
}