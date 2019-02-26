package com.example.maibenben.user;

/**
 * Created by Administrator on 2018/12/6.
 */

public class AddressBase {
    private String address;//住址
    private String housingAddress;//小区住址
    private String tenement;//物业信息
    private String date;//日期
    private boolean defult;//是否是默认地址

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHousingAddress() {
        return housingAddress;
    }

    public void setHousingAddress(String housingAddress) {
        this.housingAddress = housingAddress;
    }

    public String getTenement() {
        return tenement;
    }

    public void setTenement(String tenement) {
        this.tenement = tenement;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isDefult() {
        return defult;
    }

    public void setDefult(boolean defult) {
        this.defult = defult;
    }
}
