package com.zj.play

import android.annotation.SuppressLint
import android.view.KeyEvent
import android.view.View
import android.view.animation.*
import android.widget.Toast
import com.zj.core.view.BaseActivity
import com.zj.play.view.main.MainActivity
import kotlinx.android.synthetic.main.activity_welcome.*


class WelcomeActivity : BaseActivity(),
    View.OnClickListener {
    private var exitTime: Long = 0
    private var animationTime: Long = 500

    override fun getLayoutId(): Int {
        return R.layout.activity_welcome
    }

    override fun initData() {}

    private fun initAnimation() {
        val rotateAnimation = RotateAnimation(
            0f, 360f,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        )
        rotateAnimation.duration = animationTime
        rotateAnimation.fillAfter = true
        val scaleAnimation = ScaleAnimation(
            0f, 1f, 0f, 1f,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        )
        scaleAnimation.duration = animationTime
        scaleAnimation.fillAfter = true
        val alphaAnimation = AlphaAnimation(0f, 1f)
        alphaAnimation.duration = animationTime
        alphaAnimation.fillAfter = true
        val animationSet = AnimationSet(true)
        animationSet.addAnimation(alphaAnimation)
        rlWelcomeBg!!.startAnimation(animationSet)
        animationSet.setAnimationListener(animationListener)
    }


    @SuppressLint("SetTextI18n")
    override fun initView() {
        initAnimation()
        rlWelcomeBg.setOnClickListener(this)
    }

    private val animationListener = object : Animation.AnimationListener {
        /**
         * 动画开始的时候执行
         * @param animation
         */
        override fun onAnimationStart(animation: Animation) {}

        /**
         * 动画结束的时候执行
         * @param animation
         */
        override fun onAnimationEnd(animation: Animation) {
            //跳转到登陆界面
            jump()
        }

        /**
         * 动画重复的时候执行
         * @param animation
         */
        override fun onAnimationRepeat(animation: Animation) {}
    }

    private fun jump() {
        MainActivity.actionStart(this)
        finish()
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.rlWelcomeBg -> {
                jump()
            }
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit()
            return false
        }
        return super.onKeyDown(keyCode, event)
    }

    private fun exit() {
        if (System.currentTimeMillis() - exitTime > 2000) {
            Toast.makeText(
                applicationContext, "再按一次退出程序",
                Toast.LENGTH_SHORT
            ).show()
            exitTime = System.currentTimeMillis()
        } else {
            App.getInstance().exit()
            finish()
        }
    }

}
