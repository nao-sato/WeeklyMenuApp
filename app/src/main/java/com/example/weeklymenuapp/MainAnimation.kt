package com.example.weeklymenuapp

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.graphics.Path
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator

class MainAnimation(apple: View, f1: View, f2: View, f3: View, f4: View, phone: View) {

    val animSet = AnimatorSet().apply {
        play(Apple(apple).up).before(Apple(apple).down)
        play(Foods(f1).alphaAppear).after(Apple(apple).down)
//        play(Foods(f1).alphaAppear).with(Foods(f3).alphaAppear)
//        play(Foods(f1).alphaAppear).with(Foods(f4).alphaAppear)
//        play(Phone(phone).up).after(Foods(f4).alphaAppear)
//        play(Foods(f1).circle).after(Phone(phone).up)
//        play(Foods(f1).circle).with(Foods(f1).rotation).with(Foods(f1).alphaDisappear)
//        play(Foods(f1).circle).with(Foods(f2).circle).with(Foods(f2).rotation).with(Foods(f2).alphaDisappear)
//        play(Foods(f1).circle).with(Foods(f3).circle).with(Foods(f3).rotation).with(Foods(f3).alphaDisappear)
//        play(Foods(f1).circle).with(Foods(f4).circle).with(Foods(f4).rotation).with(Foods(f4).alphaDisappear)
//        play(Phone(phone).scaleUp_X).after(Foods(f4).alphaDisappear)
//        play(Phone(phone).scaleUp_X).with(Phone(phone).scaleUp_Y)
//        play(Phone(phone).scaleUp_X).with(Apple(apple).scaleUp_X).with(Apple(apple).scaleUp_Y)
//            .with(Apple(apple).move_X).with(Apple(apple).move_Y)
    }

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
            duration = 20
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

        val up : ObjectAnimator = ObjectAnimator.ofFloat(image, "translationX", -200f, 1000f).apply {
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