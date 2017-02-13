package com.http.request.Api;

/**
 * 回调信息统一封装类
 * Created by WZG on 2016/7/16.
 */
public class BaseResultEntity<T> {
    //  判断标示
    private int state;
    //    提示信息
    private String stateInfo;
    //显示数据（用户需要关心的数据）
    private T resInfo;

    public String getMsg() {
        return stateInfo;
    }

    public void setMsg(String msg) {
        this.stateInfo = msg;
    }

    public T getData() {
        return resInfo;
    }

    public void setData(T data) {
        this.resInfo = data;
    }

    public int getRet() {
        return state;
    }

    public void setRet(int ret) {
        this.state = ret;
    }
}
