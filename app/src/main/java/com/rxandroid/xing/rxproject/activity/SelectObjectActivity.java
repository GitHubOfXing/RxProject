package com.rxandroid.xing.rxproject.activity;

import android.os.Bundle;

import com.base.entity.classes.SelectObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.http.request.Api.BaseResultEntity;
import com.http.request.http.HttpManager;
import com.http.request.listener.HttpOnNextListener;
import com.http.request.utils.DevLog;
import com.rxandroid.xing.rxproject.BaseActivity;
import com.rxandroid.xing.rxproject.protocol.SubjectPostApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectObjectActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SubjectPostApi postEntity = new SubjectPostApi(new HttpOnNextListener<List<SelectObject>>() {
            @Override
            public void onNext(List<SelectObject> selectObjects) {
                DevLog.e("网络   返回");
            }

            @Override
            public void onCacheNext(String cache) {
            /*缓存回调*/
                DevLog.e("缓存   返回");
                Gson gson=new Gson();
                java.lang.reflect.Type type = new TypeToken<BaseResultEntity<List<Object>>>() {}.getType();
                BaseResultEntity resultEntity= gson.fromJson(cache, type);
                onNetCacheNext(resultEntity);
            }
        }, this);
        postEntity.setAll(true);
        HttpManager manager = HttpManager.getInstance();
        manager.doHttpDeal(postEntity);
    }

}