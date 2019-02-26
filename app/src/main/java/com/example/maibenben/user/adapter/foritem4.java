package com.example.maibenben.user.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

//import com.example.administrator.user.R;
//import com.example.administrator.user.base.CommentBase;

import com.example.maibenben.user.R;
import com.example.maibenben.user.base.CommentBase;

import java.util.List;

/**
 * Created by Administrator on 2018/12/11.
 */

public class foritem4 extends BaseAdapter{
    private Context context;
    private List<CommentBase>list;

    public foritem4(Context context,List<CommentBase> list){
        this.context= context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list == null?0:list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView ==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item4,null);
            viewHolder = new ViewHolder();
            viewHolder.msg = convertView.findViewById(R.id.mes1);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.msg.setText(list.get(position).getMsg());
        return convertView;
    }

    class ViewHolder {
        TextView msg;
    }
}
