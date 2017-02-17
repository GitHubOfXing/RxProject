
package com.rxandroid.xing.rxproject.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.http.request.utils.DisplayUtils;


public class AdvanceTitleView extends View {

    public AdvanceTitleView(Context context) {
        super(context);
    }

    public AdvanceTitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setAntiAlias(true);
        int centerX;
        int centerY;
        int r = (getMeasuredWidth() - DisplayUtils.dp2px(getContext(), 30) * 8) / 4;//也可以是getMeasuredHeight()/2
        //圆心的纵坐标为当前的View的顶部起始位置+半径
        centerY = getTop() + r;
        centerX = getLeft() + r;
        for(int i = 0; i < 4; i++) {
            //圆心的横坐标为当前的View的左边起始位置+半径
            if(i != 0)
            centerX = centerX+2*r+DisplayUtils.dp2px(getContext(), 20);
            //开始绘制
            canvas.drawCircle(centerX, centerY, r, paint);
        }
    }
}