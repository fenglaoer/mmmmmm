package com.example.maibenben.user;

import java.util.List;

/**
 * Created by Administrator on 2018/12/6.
 */

public class AddressListBase {//创建集合的基类 能够setget

    private List<AddressBase> list;

    public List<AddressBase> getList() {
        return list;
    }

    public void setList(List<AddressBase> list) {
        this.list = list;
    }
}
