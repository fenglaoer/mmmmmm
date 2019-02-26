package com.example.maibenben.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class address extends AppCompatActivity {
    private ListView listView;
    private SimpleAdapter simpleAdapter;
    private List<Map<String, String>> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        TextView tiao = (TextView) findViewById(R.id.tiao);
        listView = findViewById(R.id.listview);





        for (int i = 0; i < 10; i++) {
            Map<String, String> map = new HashMap<>();
            map.put("text1","住址信息");
            map.put("text2","星雨华府2期-8栋80"+i);
            map.put("text3","校区地址");
            map.put("text4","南京及时清孟大姐21"+i+"好");

            map.put("text5","物业信息");
            map.put("text6","雨润物业");
            map.put("text7","物业费截止日期");
            map.put("text8","201"+i+"年"+"12月");
            map.put("text9","删除此地址");


            map.put("name", "海南" + i);
            map.put("address", "海南生态软件园" + i);
            list.add(map);
        }
        //1、创建ArrayAdapter
//        simpleAdapter = new SimpleAdapter(this, list, R.layout.buju
//                , new String[]{"text1", "text2", "text3", "text4", "text5", "text6", "text7", "text8","text9"},
//                new int[]{R.id.text1,R.id.text2,R.id.text3,R.id.text4,R.id.text5,R.id.text6,R.id.text7,R.id.text8,R.id.text9
//                });
        //2、设置lsitVIew的apdater
        listView.setAdapter(simpleAdapter);
    }
}
