package com.rxandroid.xing.rxproject.protocol;

import com.http.request.Api.BaseApi;
import com.http.request.listener.HttpOnNextListener;
import com.http.request.selfApi.RestApi;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import retrofit2.Retrofit;
import rx.Observable;

/**
 * 测试数据
 * Created by WZG on 2016/7/16.
 */
public class SubjectPostApi extends BaseApi {
//    接口需要传入的参数 可自定义不同类型
    private boolean all;
    /*任何你先要传递的参数*/

    /**
     * 默认初始化需要给定回调和rx周期类
     * 可以额外设置请求设置加载框显示，回调等（可扩展）
     * @param listener
     * @param rxAppCompatActivity
     */
    public SubjectPostApi(HttpOnNextListener listener, RxAppCompatActivity rxAppCompatActivity) {
        super(listener,rxAppCompatActivity);
        setShowProgress(true);
        setCancel(true);
        setCache(true);
        setMothed("getSKUListChilds");
        setCookieNetWorkTime(60);
        setCookieNoNetWorkTime(24*60*60);
    }



    public boolean isAll() {
        return all;
    }

    public void setAll(boolean all) {
        this.all = all;
    }

    @Override
    public Observable getObservable(Retrofit retrofit) {
        RestApi api = retrofit.create(RestApi.class);
        return api.getSKUListChilds();
    }
}
