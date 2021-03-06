package com.rxandroid.xing.rxproject.application;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.duia.onlineconfig.api.OnlineConfigAgent;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.http.request.RxRequestContext;

/**
 * Author: xupengfei
 * Date: 2014-12-15
 * Time: 13:35
 * Direction: Application属性
 */
public class DuiaApp extends Application implements Application.ActivityLifecycleCallbacks {

    private int activityCount;

    public DuiaApp() {
    }


    @Override
    protected void attachBaseContext(Context base) {
        super .attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        RxRequestContext.init(this);
        Fresco.initialize(this);
        OnlineConfigAgent onlineConfig = OnlineConfigAgent.getInstance();
        //更新参数到本地
        //可以选择添加回调OnlineConfigAgent.OnlineConfigListener()
        //失败返回null 成功返回Key Value 的Map集合
        onlineConfig.updateOnlineConfig(this);
        registerActivityLifecycleCallbacks(this);
    }


    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(Activity activity) {


    }

    @Override
    public void onActivityResumed(Activity activity) {
        activityCount++;
        Log.d("DuiaApplication","onActivityResumed = "+activityCount);


    }

    @Override
    public void onActivityPaused(Activity activity) {
        activityCount--;
        Log.d("DuiaApplication","onActivityResumed = "+activityCount);
    }

    @Override
    public void onActivityStopped(Activity activity) {
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }

}
