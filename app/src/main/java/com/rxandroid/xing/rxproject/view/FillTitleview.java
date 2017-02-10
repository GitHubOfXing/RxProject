
package com.rxandroid.xing.rxproject.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.rxandroid.xing.rxproject.R;


public class FillTitleView extends LinearLayout {

    private FontImageView imageView;
    private FontImageView imageView2;
    private FontImageView imageView3;
    private FontImageView imageView4;


    public FillTitleView(Context context) {
        super(context);
        // 获取屏幕的高度
        imageView = new FontImageView(context);
        imageView.setText("题库");
        imageView.setImageResource(R.mipmap.sku_1);
        imageView2 = new FontImageView(context);
        imageView2.setText("视频");
        imageView2.setImageResource(R.mipmap.sku_2);
        imageView3 = new FontImageView(context);
        imageView3.setText("班级");
        imageView3.setImageResource(R.mipmap.sku_3);
        imageView4 = new FontImageView(context);
        imageView4.setText("群聊");
        imageView4.setImageResource(R.mipmap.sku_4);

        setOrientation(LinearLayout.HORIZONTAL);
        addView(imageView);
        addView(imageView2);
        addView(imageView3);
        addView(imageView4);
    }

    public FillTitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        int childCount = getChildCount();
        // 设置一个变量保存到父View左侧的距离
        int mLeft = 0;
        int spaceWidth = getMeasuredWidth()-(getChildAt(0).getMeasuredWidth()*getChildCount());
        // 遍历子View
        for (int i = 0; i < childCount; i++) {

            View childView = getChildAt(i);
            // 获得子View的高度
            int childViewHeight = childView.getMeasuredHeight();
            // 获得子View的宽度
            int childViewWidth = childView.getMeasuredWidth();
            mLeft += spaceWidth/5;
            // 调用layout给每一个子View设定位置mLeft,mTop,mRight,mBottom.左上右下
            childView.layout(mLeft, 0, mLeft + childViewWidth, childViewHeight);
            // 改变下一个子View到父View左侧的距离
            mLeft += childViewWidth;
        }
    }

}