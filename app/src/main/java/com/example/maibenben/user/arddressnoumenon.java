package com.example.maibenben.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class arddressnoumenon extends AppCompatActivity implements Template2.OnAdapterDateChangeListener{
    private ListView listView;

    private Template2 adapterListView;//适配器就是哪个item
    private List<AddressBase> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arddressnoumenon);
        listView = findViewById(R.id.listview);//找出listvie的id
        for (int i = 0; i < 20; i++) {//写个循环来把创建每个item需要的信息
            AddressBase addressBase = new AddressBase();//声明addressBase基类
            addressBase.setAddress("明月居7栋30" + i);//在里面设置他的值
            addressBase.setHousingAddress("生态软件园明月居");
            addressBase.setTenement("花样年物业");
            addressBase.setDate("2018-01-11");
            if (i == 0)//如果排在第一个就设置他为默认地址
                addressBase.setDefult(true);//设置为默认地址
            list.add(addressBase);//把这些循环创建的每一个item记录放到list集合里面
        }
        //1\实例化adpater
        adapterListView = new Template2(this, list,arddressnoumenon.this);
        //2将实例化的adapter设置给ListView
        listView.setAdapter(adapterListView);
    }
    @Override
    public void onDefalut(int position) {
        //将需要变为默认地址的对象放到List集合的第一个，并且改变default值
        AddressBase base = list.get(position);
        base.setDefult(true);
        list.add(0,list.get(position));
        list.remove(position+1);
        //将原先的默认值的default变为false
        AddressBase base1 = list.get(1);
        base1.setDefult(false);
        list.remove(1);
        list.add(1, base1);
        //更新adapter
        adapterListView.setList(list);
        adapterListView.notifyDataSetChanged();
        listView.setSelection(0);//设置完之后，限制第一个Item
    }
}
