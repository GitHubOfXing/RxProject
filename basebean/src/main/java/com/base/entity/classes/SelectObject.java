package com.base.entity.classes;


import com.base.entity.video.CourseSKU;

import java.io.Serializable;
import java.util.ArrayList;

public class SelectObject implements Serializable {
    private int dicCode;
    private String dicName;
    private int dicOrder;
    private String dicShort;
    private String dicType;
    private String liveDesc;
    private int validSign;
    private int vipSku;
    private ArrayList<CourseSKU> childs;

    public SelectObject(){

    }

    public int getDicCode() {
        return dicCode;
    }

    public void setDicCode(int dicCode) {
        this.dicCode = dicCode;
    }

    public String getDicName() {
        return dicName;
    }

    public void setDicName(String dicName) {
        this.dicName = dicName;
    }

    public int getDicOrder() {
        return dicOrder;
    }

    public void setDicOrder(int dicOrder) {
        this.dicOrder = dicOrder;
    }

    public String getDicShort() {
        return dicShort;
    }

    public void setDicShort(String dicShort) {
        this.dicShort = dicShort;
    }

    public String getDicType() {
        return dicType;
    }

    public void setDicType(String dicType) {
        this.dicType = dicType;
    }

    public String getLiveDesc() {
        return liveDesc;
    }

    public void setLiveDesc(String liveDesc) {
        this.liveDesc = liveDesc;
    }

    public int getValidSign() {
        return validSign;
    }

    public void setValidSign(int validSign) {
        this.validSign = validSign;
    }

    public int getVipSku() {
        return vipSku;
    }

    public void setVipSku(int vipSku) {
        this.vipSku = vipSku;
    }

    public ArrayList<CourseSKU> getChilds() {
        return childs;
    }

    public void setChilds(ArrayList<CourseSKU> childs) {
        this.childs = childs;
    }
}
