
package com.rxandroid.xing.rxproject.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.http.request.utils.DisplayUtils;


public class FontImageView extends LinearLayout {

    public FontImageView(Context context) {
        super(context);
        imageView = new ImageView(context);
        imageView.setPadding(20, 20, 20, 20);

        textView = new TextView(context);
        textView.setGravity(android.view.Gravity.CENTER_HORIZONTAL);
        textView.setPadding(0, 20, 0, 0);
        textView.setTextSize(DisplayUtils.dp2px(context,5));
        setClickable(true);
        setFocusable(true);
        setOrientation(LinearLayout.VERTICAL);
        addView(imageView);
        addView(textView);
    }

    public FontImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ImageView imageView;
    public TextView textView;

    public void setText(int resId) {
        textView.setText(resId);
    }

    public void setImageResource(int resId) {
        imageView.setBackgroundResource(resId);
    }

    public void setText(CharSequence buttonText) {
        textView.setText(buttonText);
    }

    public void setTextColor(int color) {
        textView.setTextColor(color);
    }

}