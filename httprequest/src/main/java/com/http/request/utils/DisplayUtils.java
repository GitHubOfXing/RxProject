package com.http.request.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

public class DisplayUtils {
	/**
	 * 将px值转换为dp值
	 */
	public static int px2dp(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}

	/**
	 * 将dp值转换为px值
	 */
	public static int dp2px(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

	/**
	 * 将px值转换为sp值
	 */
	public static int px2sp(Context context, float pxValue) {
		final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
		return (int) (pxValue / fontScale + 0.5f);
	}

	/**
	 * 将sp值转换为px值
	 */
	public static int sp2px(Context context, float spValue) {
		final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
		return (int) (spValue * fontScale + 0.5f);
	}


	/**
	 * 获取屏幕尺寸
	 */
	public static int[] getScreenSize(Activity activity) {
		DisplayMetrics metrics = new DisplayMetrics();
		activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
		return new int[] { metrics.widthPixels, metrics.heightPixels };
	}
}
