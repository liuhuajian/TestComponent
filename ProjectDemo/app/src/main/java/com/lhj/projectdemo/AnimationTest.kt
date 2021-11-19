package com.lhj.projectdemo

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.lhj.projectdemo.dialog.BackHomeWindowManager
import kotlinx.android.synthetic.main.activity_animation.*


/**
 * 项目：国民健康平台
 *  @Creator:liuhuajian
 *  @创建日期： 2020/11/4 17:38
 *  @版本0.2
 *  @类说明：
 */
class AnimationTest: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)
        begin.setOnClickListener{

            BackHomeWindowManager.instance.showWindow(this)
//            var animation = AnimatorInflater.loadAnimator(this, R.animator.transx)
//            animation.setTarget(btnBall)
//            animation.start()
//            Log.d("onCreate","left-->"+btnBall3.left)
//            ObjectAnimator.ofFloat(btnBall1, "translationX",0f,(btnBall3.left-btnBall1.left).toFloat())
//                .setDuration(500).start()
//
//            ObjectAnimator.ofFloat(btnBall2, "translationX",0f,-(btnBall2.left-btnBall1.left).toFloat())
//                .setDuration(500).start()
//
//            ObjectAnimator.ofFloat(btnBall3, "translationX",0f,-(btnBall3.left-btnBall2.left).toFloat())
//                .setDuration(500).start()
//            FocusAnimUtils.animItem(btnBall1, btnBall1.translationX, btnBall1.translationX+100,1000)
//            btnBall1.scrollTo(20,20)
        }
    }


}