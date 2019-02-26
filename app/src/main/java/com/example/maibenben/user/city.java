package com.example.maibenben.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Chronometer;
import android.widget.NumberPicker;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Map;

public class city extends AppCompatActivity {
    private String[] month = {"北京市", "天津市", "上海", "重庆"};
    private String[] xianbei ;
    private String[] xiantian ;
    private String[] xianshang ;
    private String[] xianchong;
    private NumberPicker test_numberPickerxian, test_numberPickershi;
    private TextView test;
    private int indexMonth,indexDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        test_numberPickerxian = findViewById(R.id.test_numberPickerxian);
        test_numberPickershi = findViewById(R.id.test_numberPickershi);
        test = findViewById(R.id.test_test);
        xianbei = getResources().getStringArray(R.array.xianbei);
        xiantian = getResources().getStringArray(R.array.xiantian);
        xianshang =getResources().getStringArray(R.array.xianshang);
        xianchong = getResources().getStringArray(R.array.xianchong);


        test_numberPickerxian.setDisplayedValues(month);//设置数字选择器的值
        test_numberPickerxian.setMinValue(0);//可选值得最小值
        test_numberPickerxian.setMaxValue(month.length - 1);
        test_numberPickerxian.setWrapSelectorWheel(true);//是否循环显示
        test_numberPickerxian.setValue(0);//设置默认的位置
        //设置不可编辑
        test_numberPickerxian.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);

        test_numberPickerxian.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                Log.e("111", "MonoldVal=" + oldVal + "--MonnewVal=" + newVal);
                indexMonth = newVal;
                test.setText(month[indexMonth]+xianbei[0]);
                switch (newVal + 1) {
                    case 1://1月
                        test_numberPickershi.setDisplayedValues(xianbei);//设置数字选择器的值
                        test_numberPickershi.setMinValue(0);//可选值得最小值
                        test_numberPickershi.setValue(0);
                        test_numberPickershi.setMaxValue(xianbei.length - 1);
                        break;
                    case 2://2月
                        test_numberPickershi.setMinValue(0);//可选值得最小值
                        test_numberPickershi.setMaxValue(xiantian.length - 1);
                        test_numberPickershi.setValue(0);
                        test_numberPickershi.setDisplayedValues(xiantian);//设置数字选择器的值
                        break;
                    case 3://3月
                        test_numberPickershi.setValue(0);
                        test_numberPickershi.setDisplayedValues(xianshang);//设置数字选择器的值
                        test_numberPickershi.setMinValue(0);//可选值得最小值
                        test_numberPickershi.setMaxValue(xianshang.length - 1);
                        break;
                    case 4://4月
                        test_numberPickershi.setMinValue(0);//可选值得最小值
                        test_numberPickershi.setMaxValue(xianchong.length - 1);
                        test_numberPickershi.setValue(0);
                        test_numberPickershi.setDisplayedValues(xianchong);//设置数字选择器的值
                        break;

                }
            }
        });


        test_numberPickershi.setDisplayedValues(xianbei);//设置数字选择器的值
        test_numberPickershi.setMinValue(0);//可选值得最小值
        test_numberPickershi.setMaxValue(xianbei.length - 1);
        test_numberPickershi.setValue(0);//设置默认的位置
        test_numberPickershi.setWrapSelectorWheel(true);//是否循环显示
        //设置不可编辑
        test_numberPickershi.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);

        test_numberPickershi.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                Log.e("111", "DayoldVal=" + oldVal + "--DaynewVal=" + newVal);
                indexDay = newVal;
                test.setText(month[indexMonth]+xianbei[newVal]);
            }
        });


    }
}

