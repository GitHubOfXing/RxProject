package com.rxandroid.xing.rxproject.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.http.request.Api.BaseResultEntity;
import com.http.request.listener.HttpOnNextListener;
import com.rxandroid.xing.rxproject.R;
import com.trello.rxlifecycle.components.support.RxFragment;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by li on 2016/3/23.
 */
public class BaseFragment extends RxFragment {

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    /**
     * open the new Fragment
     */
    private void open(Fragment fragment) {
        final String tag = fragment.getClass().toString();
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(tag)
                .replace(R.id.main_content, fragment, tag)
                .commit();
    }

    //   回调一一对应
    HttpOnNextListener OnNextListener = new HttpOnNextListener<List<Object>>() {
        /**
         * 网络返回
         * @param subjects
         */
        @Override
        public void onNext(List<Object> subjects) {
            onNetNext(subjects);
        }

        @Override
        public void onCacheNext(String cache) {
            /*缓存回调*/
            Gson gson=new Gson();
            java.lang.reflect.Type type = new TypeToken<BaseResultEntity<List<Object>>>() {}.getType();
            BaseResultEntity resultEntity= gson.fromJson(cache, type);
            onNetCacheNext(resultEntity);
        }

        /*用户主动调用，默认是不需要覆写该方法*/
        @Override
        public void onError(Throwable e) {
            super.onError(e);
            e.printStackTrace();
            onNetError(e);
        }

        /*用户主动调用，默认是不需要覆写该方法*/
        @Override
        public void onCancel() {
            super.onCancel();
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
