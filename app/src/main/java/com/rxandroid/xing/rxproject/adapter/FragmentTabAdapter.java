package com.rxandroid.xing.rxproject.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;
import android.widget.TabHost;

import com.rxandroid.xing.rxproject.R;
import com.rxandroid.xing.rxproject.fragment.BaseFragment;

import java.util.List;

public class FragmentTabAdapter extends FragmentPagerAdapter {
    private BaseFragment list[];; // 一个tab页面对应一个Fragment
    private FragmentManager fm;
    String[] titleArray;

    private int currentTab; // 当前Tab页面索引


    public FragmentTabAdapter(FragmentManager fm, BaseFragment list[],String[] titleArray) {
        super(fm);
        this.fm = fm;
        this.list = list;
        this.titleArray = titleArray;
    }

    /**
     * 切换tab
     * @param idx
     *//*
    private void showTab(int idx){
        for(int i = 0; i < list.length; i++){
            Fragment fragment = list[i];
            FragmentTransaction ft = obtainFragmentTransaction(idx);

            if(idx == i){
                ft.show(fragment);
            }else{
                ft.hide(fragment);
            }
            ft.commit();
        }
        currentTab = idx; // 更新目标tab为当前tab
    }

    *//**
     * 获取一个带动画的FragmentTransaction
     * @return
     *//*
    private FragmentTransaction obtainFragmentTransaction(int index){
        FragmentTransaction ft = fm.beginTransaction();
        // 设置切换动画
        if(index > currentTab){
            ft.setCustomAnimations(R.anim.slide_left_in, R.anim.slide_left_out);
        }else{
            ft.setCustomAnimations(R.anim.slide_right_in, R.anim.slide_right_out);
        }
        return ft;
    }

    public int getCurrentTab() {
        return currentTab;
    }

    public Fragment getCurrentFragment(){
        return list[currentTab];
    }

    @Override
    public void onTabChanged(String tabId) {
        for(int i = 0; i < titleArray.length; i++){
            if(tabId.equals(titleArray[i])){
                Fragment fragment = list[i];
                FragmentTransaction ft = obtainFragmentTransaction(i);

                getCurrentFragment().onPause(); // 暂停当前tab
//                getCurrentFragment().onStop(); // 暂停当前tab

                if(fragment.isAdded()){
//                    fragment.onStart(); // 启动目标tab的onStart()
                    fragment.onResume(); // 启动目标tab的onResume()
                }else{
                    ft.add(fragmentContainerId, fragment);
                }
                showTab(i); // 显示目标tab
                ft.commit();

               *//* // 如果设置了切换tab额外功能功能接口
                if(null != onRgsExtraCheckedChangedListener){
                    onRgsExtraCheckedChangedListener.OnRgsExtraCheckedChanged(mTabHost, tabId, i);
                }*//*

            }
        }
    }*/

    @Override
    public Fragment getItem(int arg0) {
        return list[arg0];
    }//根据Item的位置返回对应位置的Fragment，绑定item和Fragment

    @Override
    public int getCount() {
        return list.length;
    }//设置Item的数量

    /*public OnRgsExtraCheckedChangedListener getOnRgsExtraCheckedChangedListener() {
        return onRgsExtraCheckedChangedListener;
    }

    public void setOnRgsExtraCheckedChangedListener(OnRgsExtraCheckedChangedListener onRgsExtraCheckedChangedListener) {
        this.onRgsExtraCheckedChangedListener = onRgsExtraCheckedChangedListener;
    }

    *//**
     *  切换tab额外功能功能接口
     *//*
    public static class OnRgsExtraCheckedChangedListener{
        public void OnRgsExtraCheckedChanged(FragmentTabHost mTabHost, String tabId, int index){

        }
    }*/
}