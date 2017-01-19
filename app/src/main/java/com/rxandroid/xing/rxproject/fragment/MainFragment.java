package com.rxandroid.xing.rxproject.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rxandroid.xing.rxproject.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 主菜单Fragment
 * Created by ljb on 2016/3/23.
 */
public class MainFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, null);
        ButterKnife.bind(this, view);
        return view;
    }
}
