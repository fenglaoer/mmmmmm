package com.example.maibenben.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

public class SEx extends AppCompatActivity {
    private TextView test;
 private NumberPicker test_numberPickersex;
 private  String[] sex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sex);
        test_numberPickersex = findViewById(R.id.test_numberPickersex);
        test = findViewById(R.id.test_test);

        sex = getResources().getStringArray(R.array.sex);

        test_numberPickersex.setDisplayedValues(sex);//设置数字选择器 的值
        test_numberPickersex.setMinValue(0);//可选值的最小值
        test_numberPickersex.setMaxValue(sex.length-1);
        test_numberPickersex.setWrapSelectorWheel(true);//是否可循环
        test_numberPickersex.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);//设置不可编辑、

        Toast.makeText(SEx.this,"点击事件",Toast.LENGTH_SHORT).show();



    }
}
