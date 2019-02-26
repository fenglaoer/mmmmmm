package com.example.maibenben.user.base;

/**
 * Created by Maibenben on 2018/12/24.
 */

public class userbase {
    private String name;
    private int number;
    private String address;
    private String identity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    @Override
    public String toString() {
        return "userbase{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", address='" + address + '\'' +
                ", identity='" + identity + '\'' +
                '}';
    }
}
