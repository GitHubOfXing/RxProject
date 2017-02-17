package com.rxandroid.xing.rxproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;

import com.badoo.mobile.util.WeakHandler;
import com.http.request.utils.AppUtil;
import com.rxandroid.xing.rxproject.MainActivity;
import com.rxandroid.xing.rxproject.R;
import com.rxandroid.xing.rxproject.fragment.TestFragment;
import com.rxandroid.xing.rxproject.util.WelcomeUtil;

public class WelcomeActivity extends FragmentActivity {
    private String welcomeImageUrl = "http://img3.duitang.com/uploads/blog/201403/26/20140326140216_xednQ.thumb.700_0.jpeg";
    private static final String TAG = "WelcomeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        final View welcome = LayoutInflater.from(this).inflate(R.layout.welcome_layout, null);
        final AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(1000);
        welcome.startAnimation(alphaAnimation);
        setContentView(welcome);
        WelcomeUtil.open(welcome, welcomeImageUrl, new WelcomeUtil.OnWelcomeDone() {
            @Override
            public void onDone() {
                Log.d(TAG, "onDone: ");
                if (AppUtil.isNetworkAvailable(getApplicationContext())) {
                        /*没网不显示 广告是不是vip用户不显示 没下载下来图片不显示 */
                    TestFragment welcomeBannerFragment = new TestFragment();
                    getSupportFragmentManager().beginTransaction().add(R.id.wel_bg_rl, welcomeBannerFragment).commitAllowingStateLoss();
                    overridePendingTransition(R.anim.alpha_in, 0);
                    new WeakHandler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            intoMain();
                        }
                    },3000);
                } else {
                    intoMain();
                    Log.e("WelcomeFinish", "======finish=======into()===11111111=");
                    finish();
                }
            }
        });
        /*WelcomeUtil.open(this, welcomeImageUrl, new WelcomeUtil.OnWelcomeDone() {
            @Override
            public void onDone() {
                Log.d(TAG, "onDone: ");
                Intent intent = new Intent(getApplicationContext(),
                        MainActivity.class);
                startActivity(intent);
                finish();
            }
        });*/
    }

    private void intoMain() {
        Intent intent = new Intent(getApplicationContext(),
                MainActivity.class);
        startActivity(intent);
        finish();
    }
}