package com.rxandroid.xing.rxproject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.http.request.Api.BaseResultEntity;
import com.http.request.listener.HttpOnNextListener;
import com.http.request.utils.DevLog;
import com.http.request.utils.RxBus;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import java.util.List;


public class BaseActivity extends RxAppCompatActivity {

    private RxBus _rxBus;


    /**获取RxBus对象*/
    public RxBus getRxBusSingleton() {
        if (_rxBus == null) {
            _rxBus = new RxBus();
        }
        return _rxBus;
    }

    protected HttpOnNextListener OnNextListener = new HttpOnNextListener<List<Object>>() {
        /**
         * 网络返回
         * @param subjects
         */
        @Override
        public void onNext(List<Object> subjects) {
            DevLog.e("网络返回");
            onNetNext(subjects);
        }

        @Override
        public void onCacheNext(String cache) {
            /*缓存回调*/
            DevLog.e("缓存返回");
            Gson gson=new Gson();
            java.lang.reflect.Type type = new TypeToken<BaseResultEntity<List<Object>>>() {}.getType();
            BaseResultEntity resultEntity= gson.fromJson(cache, type);
            onNetCacheNext(resultEntity);
        }

        /*用户主动调用，默认是不需要覆写该方法*/
        @Override
        public void onError(Throwable e) {
            super.onError(e);
            DevLog.e("网络错误",e);
            onNetError(e);
        }

        /*用户主动调用，默认是不需要覆写该方法*/
        @Override
        public void onCancel() {
            super.onCancel();
            DevLog.e("网络取消");
        }
    };

    /**
     * 留待子类实现   网络返回
     * @param subjects
     */
    public void onNetNext(List<Object> subjects) {

    }
    /**
     * 留待子类实现  网络缓存返回
     * @param resultentity
     */
    public void onNetCacheNext(BaseResultEntity resultentity) {

    }
    /**
     * 留待子类实现  网络失败
     * @param e
     */
    public void onNetError(Throwable e) {

    }
}
