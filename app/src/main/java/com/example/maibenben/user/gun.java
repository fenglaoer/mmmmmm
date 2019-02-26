package com.example.maibenben.user;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Map;

public class gun extends AppCompatActivity {
    private String[] month = {"1月", "2月", "3月", "4月", "5月"};
    private String[] day31 ;
    private String[] day30 ;
    private String[] day28 ;
    private NumberPicker test_numberPickerMonth, test_numberPickerDay;
    private TextView test;
    private int indexMonth,indexDay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gun);

        test_numberPickerMonth = findViewById(R.id.test_numberPickerMonth);
        test_numberPickerDay = findViewById(R.id.test_numberPickerDay);
        test = findViewById(R.id.test_test);
        day31 = getResources().getStringArray(R.array.day31);
        day30 = getResources().getStringArray(R.array.day30);
        day28 =getResources().getStringArray(R.array.day28);





        test_numberPickerMonth.setDisplayedValues(month);//设置数字选择器的值
        test_numberPickerMonth.setMinValue(0);//可选值得最小值
        test_numberPickerMonth.setMaxValue(month.length - 1);
        test_numberPickerMonth.setWrapSelectorWheel(true);//是否循环显示
        test_numberPickerMonth.setValue(0);//设置默认的位置
        //设置不可编辑
        test_numberPickerMonth.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);

        test_numberPickerMonth.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                Log.e("111", "MonoldVal=" + oldVal + "--MonnewVal=" + newVal);
                indexMonth = newVal;
                test.setText(month[indexMonth]+day31[0]);
                switch (newVal + 1) {
                    case 1://1月
                        test_numberPickerDay.setDisplayedValues(day31);//设置数字选择器的值
                        test_numberPickerDay.setMinValue(0);//可选值得最小值
                        test_numberPickerDay.setValue(0);
                        test_numberPickerDay.setMaxValue(day31.length - 1);
                        break;
                    case 2://2月
                        test_numberPickerDay.setMinValue(0);//可选值得最小值
                        test_numberPickerDay.setMaxValue(day28.length - 1);
                        test_numberPickerDay.setValue(0);
                        test_numberPickerDay.setDisplayedValues(day28);//设置数字选择器的值
                        break;
                    case 3://3月
                        test_numberPickerDay.setValue(0);
                        test_numberPickerDay.setDisplayedValues(day31);//设置数字选择器的值
                        test_numberPickerDay.setMinValue(0);//可选值得最小值
                        test_numberPickerDay.setMaxValue(day31.length - 1);
                        break;
                    case 4://4月
                        test_numberPickerDay.setMinValue(0);//可选值得最小值
                        test_numberPickerDay.setMaxValue(day30.length - 1);
                        test_numberPickerDay.setValue(0);
                        test_numberPickerDay.setDisplayedValues(day30);//设置数字选择器的值
                        break;
                    case 5://5月
                        test_numberPickerDay.setValue(0);
                        test_numberPickerDay.setDisplayedValues(day31);//设置数字选择器的值
                        test_numberPickerDay.setMinValue(0);//可选值得最小值
                        test_numberPickerDay.setMaxValue(day31.length - 1);
                        break;
                }
            }
        });


        test_numberPickerDay.setDisplayedValues(day31);//设置数字选择器的值
        test_numberPickerDay.setMinValue(0);//可选值得最小值
        test_numberPickerDay.setMaxValue(day31.length - 1);
        test_numberPickerDay.setValue(0);//设置默认的位置
        test_numberPickerDay.setWrapSelectorWheel(true);//是否循环显示
        //设置不可编辑
        test_numberPickerDay.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);

        test_numberPickerDay.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                Log.e("111", "DayoldVal=" + oldVal + "--DaynewVal=" + newVal);
                indexDay = newVal;
                test.setText(month[indexMonth]+day31[newVal]);
            }
        });



    }
}
