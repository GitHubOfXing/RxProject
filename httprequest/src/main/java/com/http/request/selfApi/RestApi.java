package com.http.request.selfApi;

import com.base.entity.classes.SelectObject;
import com.http.request.Api.BaseResultEntity;
import java.util.List;

import retrofit2.http.POST;
import rx.Observable;

public interface RestApi {
    /**
     * sku分类
     */
    @POST(RequestUrlCons.GETSKULISTCHILD_POST_URL)
    Observable<BaseResultEntity<List<SelectObject>>> getSKUListChilds();
}
