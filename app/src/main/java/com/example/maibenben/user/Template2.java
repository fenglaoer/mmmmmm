package com.example.maibenben.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.maibenben.user.R;
import com.example.maibenben.user.AddressBase;
import com.example.maibenben.user.AddressListBase;
//import com.example.administrator.user.R;
//import com.zxy.baseproject.R;
//import com.example.administrator.user.AddressBase;
//import com.example.administrator.user.listview.base.AddressListBase;
//import com.example.administrator.user.AddressListBase;
import java.util.List;

public class Template2 extends BaseAdapter {
    private Context mContext;
    private List<AddressBase> list;//数据源/
    private OnAdapterDateChangeListener onAdapterDateChangeListener;
    public List<AddressBase> getList() {
        return list;
    }

    public void setList(List<AddressBase> list) {
        this.list = list;
    }

    public Template2(Context mContext, List<AddressBase> list,
                           OnAdapterDateChangeListener onAdapterDateChangeListener) {
        this.mContext = mContext;
        this.list = list;
        this.onAdapterDateChangeListener = onAdapterDateChangeListener;
    }

    public interface OnAdapterDateChangeListener {
        void onDefalut(int position);//创建一个
    }

    //个数
    @Override
    public int getCount() {
        return list.size();
    }

    //数据源的Item对象
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    //数据源Item绑定的Id
    @Override
    public long getItemId(int position) {
        return position;
    }

    //设置Item显示的VIew
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        AddressBase addressBase = list.get(position);
        if (convertView == null) {
            //引入adpater适配器的Item的布局文件
            convertView = LayoutInflater.from(mContext).inflate(R.layout.activity_template2, null);
            //去获取Item布局文件的Item
        }
        TextView address = convertView.findViewById(R.id.apdater_listview_tv_address);
        TextView housingAddress = convertView.findViewById(R.id.apdater_listview_tv_housingAddress);
        TextView tenement = convertView.findViewById(R.id.apdater_listview_tv_tenement);
        TextView date = convertView.findViewById(R.id.apdater_listview_tv_date);
        TextView todayAddress = convertView.findViewById(R.id.apdater_listview_tv_todayAdrress);
        TextView defaultAddress = convertView.findViewById(R.id.apdater_listview_tv_defaultAddress);


        address.setText(addressBase.getAddress());
        housingAddress.setText(addressBase.getHousingAddress());
        tenement.setText(addressBase.getTenement());
        date.setText(addressBase.getDate());
        if (addressBase.isDefult()) {//默认地址
            todayAddress.setVisibility(View.VISIBLE);
            defaultAddress.setVisibility(View.GONE);
        } else {
            todayAddress.setVisibility(View.GONE);
            defaultAddress.setVisibility(View.VISIBLE);
        }
        //设置为默认地址
        defaultAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("11","defaultAddress");
                onAdapterDateChangeListener.onDefalut(position);
            }
        });

        return convertView;
    }
}
