package com.example.maibenben.user;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.maibenben.user.what;

import org.w3c.dom.Text;

public class usermain extends AppCompatActivity {
    private final static int REQUST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usermain);
        ImageView fanhui = (ImageView) findViewById(R.id.fanhui);//
        ImageView sex =(ImageView) findViewById(R.id.xingbie);
        ImageView city = (ImageView) findViewById(R.id.chengshi);
        ImageView gaiming = (ImageView) findViewById(R.id.gaiming);
        TextView mingzi  =(TextView) findViewById(R.id.mingzi);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);



        city.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this,"点击事件",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(usermain.this, city.class);
                startActivity(i);
            }});


        sex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this,"点击事件",Toast.LENGTH_SHORT).show();
                Intent i=new Intent(usermain.this,SEx.class);
                startActivity(i);
            } });

        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this,"点击事件",Toast.LENGTH_SHORT).show();
                Intent i=new Intent(usermain.this,gun.class);
                startActivity(i);
            } });

    }
    public void OnIntentResult(View view){
        TextView mingzi = (TextView) findViewById(R.id.mingzi);
        Intent intent = new Intent();
        intent.setClass(usermain.this,changename.class);
        intent.putExtra("name",mingzi.getText());
        startActivityForResult(intent, REQUST_CODE);
    }
    public void dizhi(View view){
        Intent i = new Intent(usermain.this,arddressnoumenon.class);
        startActivity(i);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        TextView mingzi  =(TextView) findViewById(R.id.mingzi);
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("111", "返回的名字为:");
        switch (resultCode) {
            case 2:
                if (data != null) {
                    try {

                        String name = data.getStringExtra("name");
                        Log.e("111", "返回的名字为:" + name);
                        mingzi.setText(name);
                    } catch (Exception e) {

                    }

                }
                break;
        }
    }
}
