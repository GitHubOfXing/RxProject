package com.rxandroid.xing.rxproject.net;

import com.base.entity.business.BaseModle;
import com.base.entity.business.classes.SelectObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;

public interface RestApi {
    /**
     * sku分类
     */
    @POST(RequestUrlCons.GETSKULISTCHILD_POST_URL)
    Call<BaseModle<List<SelectObject>>> getSKUListChilds();
}
