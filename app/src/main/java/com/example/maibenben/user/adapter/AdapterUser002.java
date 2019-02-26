package com.example.maibenben.user.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.maibenben.user.R;
import com.example.maibenben.user.base.CommentBase;
import com.example.maibenben.user.base.userbase;

import java.util.List;

/**
 * Created by Maibenben on 2018/12/24.
 */

public class AdapterUser002 extends BaseAdapter{
    private Context context;
   private List<userbase> list;//假数据

    public AdapterUser002(Context context, List<userbase> list){
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
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.adapter_useritem002,null);
            viewHolder = new ViewHolder();
            viewHolder.tv_name=convertView.findViewById(R.id.xingming);
            viewHolder.tv_idenity = convertView.findViewById(R.id.shenfen);
            viewHolder.tv_number = convertView.findViewById(R.id.dianhua);
            viewHolder.tv_address=convertView.findViewById(R.id.dizhi );
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }
        //////

        return convertView;
    }
    class ViewHolder {
        TextView tv_name,tv_number,tv_address,tv_idenity;
    }

}
