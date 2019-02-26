package com.example.maibenben.user.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.example.maibenben.user.R;
//import com.example.administrator.user.R;
//import com.zxy.R;
/**
 * Created by Administrator on 2018/12/12.
 */

public class ListViewFlushiLoad  extends ListView implements AbsListView.OnScrollListener{
    private View headView, footView;
    private int headHeight = 0;
    private TextView headtxt;

    private int footHeight = 0;

    private float downY = 0;
    private float moveY = 0;
    private float temp = 0;
    private int downPosition=0;

    public ListViewFlushiLoad(Context context) {
        super(context);
        init(context);
    }

    public ListViewFlushiLoad(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ListViewFlushiLoad(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }

    public void init(Context mContext) {
        headView = LayoutInflater.from(mContext).inflate(R.layout.head, null);
        footView = LayoutInflater.from(mContext).inflate(R.layout.foot, null);
       // headtxt = headView.findViewById(R.id.headtxt);

        Log.e("111", headHeight + "headHeight");
        Log.e("111", footHeight + "footHeight");

        headView.measure(0, 0);
        footView.measure(0, 0);

        headHeight = headView.getMeasuredHeight();
        footHeight = footView.getMeasuredHeight();


        addHeaderView(headView);
        addFooterView(footView);

        completeView();
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downPosition = getFirstVisiblePosition();
                downY = ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                moveY = ev.getY();
                temp = moveY - downY;

                if (temp > 0 && getFirstVisiblePosition() == 0 && downPosition==0) {
                    headView.setPadding(0, (int) temp, 0, 0);
                    if (temp > 3 * headHeight) {
                        headView.setPadding(0, (int) 3 * headHeight, 0, 0);
                    } else {
                        headView.setPadding(0, (int) temp, 0, 0);
                    }
                }
                if (temp > 2 * headHeight) {
                    headtxt.setText("可刷新");
                } else {
                    headtxt.setText("不可刷新");
                }
                break;
            case MotionEvent.ACTION_UP:
                if (temp > 2 * headHeight && downPosition==0) {
                    headView.setPadding(0, (int) headHeight, 0, 0);
                    new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            try {
                                Thread.sleep(2000l);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            handler.sendEmptyMessage(1);
                        }
                    }.start();
                }else{
                    completeView();
                }
                break;
        }

        return super.onTouchEvent(ev);
    }

    public void completeView() {
        headView.setPadding(0, -headHeight, 0, 0);
        headView.setPadding(0, -footHeight, 0, 0);

    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            completeView();
        }
    };
}

