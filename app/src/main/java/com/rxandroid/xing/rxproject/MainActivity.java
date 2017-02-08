package com.rxandroid.xing.rxproject;

import android.os.Bundle;

import com.rxandroid.xing.rxproject.fragment.MainFragment;
import com.rxandroid.xing.rxproject.util.RxBus;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

public class MainActivity extends RxAppCompatActivity {

    private RxBus _rxBus;

    /**获取RxBus对象*/
    public RxBus getRxBusSingleton() {
        if (_rxBus == null) {
            _rxBus = new RxBus();
        }
        return _rxBus;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
    }

    private void initFragment() {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_tab_pager, new MainFragment(), MainFragment.class.getName())
                .add(R.id.main_tab_pager, new MainFragment(), MainFragment.class.getName())
                .add(R.id.main_tab_pager, new MainFragment(), MainFragment.class.getName())
                .add(R.id.main_tab_pager, new MainFragment(), MainFragment.class.getName())
                .commit();
    }
}
