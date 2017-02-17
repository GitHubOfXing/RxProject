package com.rxandroid.xing.rxproject.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.http.request.http.HttpManager;
import com.rxandroid.xing.rxproject.R;
import com.rxandroid.xing.rxproject.adapter.AdvPagerAdapter;
import com.rxandroid.xing.rxproject.protocol.SubjectPostApi;
import com.rxandroid.xing.rxproject.view.FillTitleView;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by li on 2016/3/23.
 */
public class TestFragment extends BaseFragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, container,false);
        ButterKnife.bind(this, view);
        return view;
    }

}
