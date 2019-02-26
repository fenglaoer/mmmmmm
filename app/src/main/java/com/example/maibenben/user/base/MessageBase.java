package com.example.maibenben.user.base;

import java.util.List;
/**
 * Created by Administrator on 2018/12/12.
 */

public class MessageBase {
    private String name;
    private String Ftime;
    private String msg;
    private boolean isZan;
    private boolean redZan;
    private String headImg;
    private String textzan;
    private List<CommentBase> list;//多个评论集合

    public String getTextzan() {
        return textzan;
    }

    public void setTextzan(String textzan) {
        this.textzan = textzan;
    }

    public boolean isRedZan() {
        return redZan;
    }

    public void setRedZan(boolean redZan) {
        this.redZan = redZan;
    }



    public String getFtime() {
        return Ftime;
    }

    public void setFtime(String ftime) {
        Ftime = ftime;
    }

    public String getName() {
        return name;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public List<CommentBase> getList() {
        return list;
    }

    public void setZan(boolean zan) {
        isZan = zan;
    }
    public boolean isZan() {
        return isZan;
    }

    public void setList(List<CommentBase> list) {
        this.list = list;


    }
}

