package com.base.entity.classes;

import java.io.Serializable;

/**
 * Author: xupengfei
 * Date: 2015-01-16
 * Time: 10:25
 * Direction: 首页广告
 */
public class AppBaoBan implements Serializable{

    private int groupIdSp;
    private int topicIdSp;
    private int skuId;
    private String collegeName;
    private String data;
    private int type;
    private String url;

    public int getGroupIdSp() {
        return groupIdSp;
    }

    public void setGroupIdSp(int groupIdSp) {
        this.groupIdSp = groupIdSp;
    }

    public int getTopicIdSp() {
        return topicIdSp;
    }

    public void setTopicIdSp(int topicIdSp) {
        this.topicIdSp = topicIdSp;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public int getSkuId() {
        return skuId;
    }

    public void setSkuId(int skuId) {
        this.skuId = skuId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
