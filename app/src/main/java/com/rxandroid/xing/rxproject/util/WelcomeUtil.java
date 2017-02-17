package com.rxandroid.xing.rxproject.util;

import android.app.Activity;
import android.net.Uri;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.rxandroid.xing.rxproject.R;

/**
 * Created by bzby on 17-2-10.
 */

public class WelcomeUtil {

    public interface OnWelcomeDone {
        void onDone();
    }

    private static final String TAG = "WelcomeUtil";

    public static void open(final View welcome, String imageUrl, final OnWelcomeDone onWelcomeDone) {
        final AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(1000);
        welcome.startAnimation(alphaAnimation);

        Uri uri = Uri.parse(imageUrl);
        ((SimpleDraweeView)welcome.findViewById(R.id.iv_pic)).setImageURI(uri);

        new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                AlphaAnimation alphaAnimation1 = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation1.setDuration(1000);
                welcome.startAnimation(alphaAnimation1);
                if (onWelcomeDone != null) {
                    onWelcomeDone.onDone();
                }
            }
        }.start();
    }

    public static void load(String url, SimpleDraweeView draweeView, int width, int height) {
        Uri uri;
        if (TextUtils.isEmpty(url)) {
            return;
        } else {
            uri = Uri.parse(url);
        }
        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                .setResizeOptions(new ResizeOptions(width, height))
                //缩放,在解码前修改内存中的图片大小, 配合Downsampling可以处理所有图片,否则只能处理jpg,
                // 开启Downsampling:在初始化时设置.setDownsampleEnabled(true)
                .setProgressiveRenderingEnabled(true)//支持图片渐进式加载
                .setAutoRotateEnabled(true) //如果图片是侧着,可以自动旋转
                .build();

        PipelineDraweeController controller =
                (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                        .setImageRequest(request)
                        .setOldController(draweeView.getController())
                        .setAutoPlayAnimations(true) //自动播放gif动画
                        .build();

        draweeView.setController(controller);
    }

}