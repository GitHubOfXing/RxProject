package com.base.entity;

/**
 * Created by duia on 2016/1/21.
 */
public class BaseModle<T> {
    public static int STATE_SUCCESS = 0;
    public static int STATE_FAILURE = 1;
    public static int STATE_EXCEPTION = -1;
    /**
     * 0成功   1失败   -1异常
     */
    private int state;
    private String stateInfo;

    private T resInfo;

    public T getResInfo() {
        return resInfo;
    }

    public void setResInfo(T resInfo) {
        this.resInfo = resInfo;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }
}
