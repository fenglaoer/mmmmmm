package com.example.maibenben.user;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.maibenben.user.base.userbase;

import com.example.maibenben.user.adapter.AdapterUser002;

public class Tongxnlu002 extends AppCompatActivity {
    private ListView listView;
    private AdapterUser002 adapterUser002;
    private userbase userbase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tongxnlu002);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        listView = (ListView) findViewById(R.id.lv_user);
        ImageView imageView =(ImageView) findViewById(R.id.zhengjia);



        LinearLayout linearLayout =(LinearLayout) findViewById(R.id.item);
        ImageView imageView1 = (ImageView) findViewById(R.id.xiugai);

        //向右的图片的点击事件
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Tongxnlu002.this, "跳转到修改页面", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Tongxnlu002.this,change002.class);
                startActivity(intent);
            }
        });
        //每个item的点击事件////////
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Tongxnlu002.this, "跳到call ", Toast.LENGTH_LONG).show();
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });
        //右下图片的跳转
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Tongxnlu002.this, "跳到添加联系人界面", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Tongxnlu002.this,adduser002.class);
                startActivity(intent);
            }
        });
    }
}
