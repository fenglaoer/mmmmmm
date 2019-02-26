package com.example.maibenben.user.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

//import com.example.administrator.user.R;
//import com.example.administrator.user.base.MessageBase;
//import com.example.administrator.user.utils.MyListView;

import com.example.maibenben.user.R;
import com.example.maibenben.user.base.MessageBase;
import com.example.maibenben.user.utils.MyListView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Administrator on 2018/12/11.
 */

public class foritem3 extends BaseAdapter{

    private Context context;
    private foritem4 foritem4;
    private int zanshu  =  0;
    private List<MessageBase> list;//数据源
    private onforitem3Listener onforitem3Listener;




    ViewHolder viewHolder = null;

    public void setList(List<MessageBase> list) {
        this.list = list;
       ;
    }

    //接口回调
    public interface onforitem3Listener {
        void onZan(int index, boolean flag);
        void onredZan(int index, boolean flag);
       // void onComment(int index);

    }


    public foritem3(Context context,List<MessageBase> list,onforitem3Listener onforitem3Listener){

        this.context = context;
        this.list = list;
        this.onforitem3Listener = onforitem3Listener;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public int getCount() {
        return list==null?0:list.size();
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
    public View getView(final int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_item3,null);
            viewHolder  = new ViewHolder();
            //viewHolder.Ftime = convertView.findViewById(R.id.pingluntame);
           // viewHolder.iv_headImg=convertView.findViewById(R.id.adpater_question_headImg);
            //viewHolder.listView = convertView.findViewById(R.id.adapter_question_listView);
            viewHolder.listView = convertView.findViewById(R.id.adapter_question_listView);
           // viewHolder.name = convertView.findViewById(R.id.adapter_question_name);
           // viewHolder.msg = convertView.findViewById(R.id.adapter_question_msg);
            viewHolder.iv_zan = convertView.findViewById(R.id.activity_item3_IV_pinglun);
           // viewHolder.redZan = convertView.findViewById(R.id.redZan);
            //viewHolder.tv_zantext = convertView.findViewById(R.id.textzan);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder ) convertView.getTag();
        }
      // viewHolder.Ftime.setText(list.get(position).getFtime());
      // viewHolder.name.setText(list.get(position).getName());
       // viewHolder.msg.setText(list.get(position).getMsg());
/////////
        //已经点红赞text+1////////////////////////////
        ////////////////////////////////////////////
//        if (list.get(position).isRedZan()){
//            viewHolder.redZan.setChecked(true);
//        }
//        else {
//            viewHolder.redZan.setChecked(false);
//        }
        //红赞点击事件
//        viewHolder.redZan.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View v) {
//             // viewHolder.tv_zantext.setText(zanshu+1);
//                //每次从他那里gettext然后输出
//                String zhanshu  = viewHolder.tv_zantext.getText().toString();
//
//                int zhanshuInt = Integer.parseInt(zhanshu);
//                viewHolder.tv_zantext.setText((zhanshuInt++)+"");
//
//                //从这里改的话没有改变数据源
//                //setText 里面默认是字符串的
//                if(list.get(position).isRedZan()){
//                    onforitem3Listener.onredZan(position,false);
//
//
//                }else {
//                    onforitem3Listener.onredZan(position,true);
//                }
//            }
//        });



        if (list.get(position).isZan()) {//已经点赞
           // viewHolder.iv_zan.setImageResource(R.mipmap.pinglun_chufa);
            //  viewHolder.iv_zan.setBackgroundResource(mContext.getResources().getColor(R.color.colorPrimary));
        } else {
           // viewHolder.iv_zan .setImageResource(R.mipmap.pinglun_moren);
        }
        //点赞的点击事件
        viewHolder.iv_zan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (list.get(position).isZan()) {//如果本身是点过赞的，就变为默认的
                 //   viewHolder.iv_zan.setImageResource(R.mipmap.tianjia);
                    onforitem3Listener.onZan(position,false);
                } else {//反之泽凡
                   // viewHolder.iv_zan.setImageResource(R.mipmap.tianjia);
                    onforitem3Listener.onZan(position,true);
                }
            }


        });
//
//        viewHolder.iv_zan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onforitem3Listener.onZan(position,true);
//            }
//        });




        //评论的适配器
        foritem4 = new foritem4(context,list.get(position).getList());

        viewHolder.listView.setAdapter(foritem4);
        return convertView;
    }
    class ViewHolder {
        CircleImageView iv_headImg;
        MyListView listView;
        TextView name,msg,Ftime;
        ImageView iv_zan;
        com.sackcentury.shinebuttonlib.ShineButton redZan;
        TextView tv_zantext;
      //  ImageView iv_comment;
    }
}
