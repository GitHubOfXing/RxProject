package com.rxandroid.xing.rxproject;

import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import com.rxandroid.xing.rxproject.adapter.FragmentTabAdapter;
import com.rxandroid.xing.rxproject.fragment.BaseFragment;
import com.rxandroid.xing.rxproject.fragment.ClassFragment;
import com.rxandroid.xing.rxproject.fragment.MainFragment;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity implements ViewPager.OnPageChangeListener, TabHost.OnTabChangeListener {

    private BaseFragment fragmentArray[] = {
            new MainFragment(),
            new ClassFragment(),
            new MainFragment(),
            new ClassFragment(),
    };

    private String[] titleArray;

    private int iconArray[] = {
            R.drawable.icon_main,
            R.drawable.icon_class,
            R.drawable.icon_chat,
            R.drawable.icon_center,
    };

    @Bind(R.id.tabhost)
    FragmentTabHost mTabHost;
    @Bind(R.id.main_tab_pager)
    ViewPager main_tab_pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initFragment();
    }

    private void initFragment() {

        titleArray = new String[]{getString(R.string.mainact_tab_main),
                getString(R.string.mainact_tab_find),
                getString(R.string.mainact_tab_chat),
                getString(R.string.mainact_tab_mine),
        };
        main_tab_pager.addOnPageChangeListener(this);
        mTabHost.setOnTabChangedListener(this);

        mTabHost.setup(this, getSupportFragmentManager(), R.id.main_tab_pager);
        mTabHost.getTabWidget().setDividerDrawable(null);

        int count = fragmentArray.length;
        for (int i = 0; i < count; i++) {
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(titleArray[i]).setIndicator(getTabItemView(i));
            mTabHost.addTab(tabSpec, fragmentArray[i].getClass(), null);
            mTabHost.setTag(i);
        }

        FragmentTabAdapter tabAdapter = new FragmentTabAdapter(getSupportFragmentManager(), fragmentArray,titleArray);
        main_tab_pager.setAdapter(tabAdapter);
    }

    private View getTabItemView(int index) {
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View view = layoutInflater.inflate(R.layout.duiaapp_tab_bottom_nav, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.iv_icon);
        imageView.setImageResource(iconArray[index]);

        TextView textView = (TextView) view.findViewById(R.id.tv_icon);
        textView.setText(titleArray[index]);
        view.setTag(String.valueOf(index));
        return view;
    }


    @Override
    public void onPageScrollStateChanged(int arg0) {

    }//arg0 ==1的时候表示正在滑动，arg0==2的时候表示滑动完毕了，arg0==0的时候表示什么都没做，就是停在那。

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {

    }//表示在前一个页面滑动到后一个页面的时候，在前一个页面滑动前调用的方法

    @Override
    public void onPageSelected(int arg0) {//arg0是表示你当前选中的页面位置Postion，这事件是在你页面跳转完毕的时候调用的。
        TabWidget widget = mTabHost.getTabWidget();
        int oldFocusability = widget.getDescendantFocusability();
        widget.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);//设置View覆盖子类控件而直接获得焦点
        mTabHost.setCurrentTab(arg0);//根据位置Postion设置当前的Tab
        widget.setDescendantFocusability(oldFocusability);//设置取消分割线
    }

    @Override
    public void onTabChanged(String tabId) {//Tab改变的时候调用
        int position = mTabHost.getCurrentTab();
        main_tab_pager.setCurrentItem(position);//把选中的Tab的位置赋给适配器，让它控制页面切换
    }

}
