package com.example.maibenben.user;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.maibenben.user.adapter.foritem3;
import com.example.maibenben.user.base.CommentBase;
//import com.example.administrator.user.base.FriendOBase;
//import com.example.administrator.user.base.MessageBase;
import com.example.maibenben.user.base.FriendOBase;
import com.example.maibenben.user.base.MessageBase;
import com.example.maibenben.user.utils.MyListView;
import com.sackcentury.shinebuttonlib.ShineButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Publicservice2 extends AppCompatActivity implements foritem3.onforitem3Listener {
    private foritem3 foritem3;
    private LinearLayout ll_input;//那个隐藏的  输入框
    private EditText et_input;//隐藏的  编辑框
    private int position=0;
    private com.example.maibenben.user.utils.MyListView listView2;
    private ListView listView;
    private List<MessageBase> list;
    private FriendOBase friendOBase;
   // private SimpleAdapter simpleAdapter;  这是另外一个
 //   private List<Map<String,String >>list = new ArrayList<>();
    private Boolean b_sub_square = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publicservice2);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        listView = (ListView) findViewById(R.id.ListView1);
        ll_input = findViewById(R.id.main_ll);
        et_input = findViewById(R.id.main_inputContext);
        friendOBase = new FriendOBase();




       listView2 = (MyListView) findViewById(R.id.adapter_question_listView);
        initData();
        // ImageView zan = (ImageView) findViewById(R.id.zan);
        // final Button zan = (Button) findViewById(R.id.zan);

        foritem3 = new foritem3(Publicservice2.this, friendOBase.getList() ,Publicservice2.this);
        listView.setAdapter(foritem3);



//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(Publicservice2.this, "cao", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent();
//                intent.setAction(Intent.ACTION_DIAL);
//                intent.setData(Uri.parse("tel:10086"));
//                startActivity(intent);
//            }
//        });
    }





//      simple adapter那个采用的数据源
//        for (int i = 0;  i < 20 ;i++){
//            Map<String, String> map = new HashMap<>();
//            map.put("text1","用户"+i);
//            map.put("text2","时间"+i);
//            map.put("text3",""+i);

//            map.put("text5","物业信息");
//            map.put("text6","雨润物业");
//            map.put("text7","物业费截止日期");
//            map.put("text8","201"+i+"年"+"12月");
//            map.put("text9","删除此地址");
//
//
//            map.put("name", "海南" + i);
//            map.put("address", "海南生态软件园" + i);
//            list.add(map);
//        }






        //1、创建ArrayAdapter
//        simpleAdapter = new SimpleAdapter(this, list, R.layout.buju
//                , new String[]{"text1", "text2", "text3", "text4", "text5", "text6", "text7", "text8","text9"},
//                new int[]{R.id.text1,R.id.text2,R.id.text3,R.id.text4,R.id.text5,R.id.text6,R.id.text7,R.id.text8,R.id.text9
//                });
//        //2、设置lsitVIew的apdater
//        listView.setAdapter(simpleAdapter);






//        simpleAdapter = new SimpleAdapter(this, list, R.layout.item2
//                , new String[]{"text1", "text2", "text3"},
//                new int[]{R.id.text1,R.id.text2,R.id.text3
//                });
//        //2、设置lsitVIew的apdater
//        listView.setAdapter(simpleAdapter);
        public void initData(){
            list = new ArrayList<MessageBase>();
            for(int i=0;i<1;i++){
                MessageBase messageBase = new MessageBase();
                //messageBase.setFtime("2018_12_12_15:"+i);
               // messageBase.setName("二狗"+(i+1));
              //  messageBase.setMsg("天狗甜到最后一无所有"+(i+1));
                List<CommentBase> list_comment = new ArrayList<>();
                for (int j = 0; j < 1; j++) {
                    CommentBase commentBase = new CommentBase();
                    commentBase.setMsg("10086");
                    list_comment.add(commentBase);
                }
                messageBase.setList(list_comment);
                list.add(messageBase);
            }
            friendOBase.setList(list);





    }

    @Override
    public void onZan(int index, boolean flag) {
        MessageBase messageBase = friendOBase.getList().get(index);
        messageBase.setZan(flag);
        //Toast.makeText(Publicservice2.this,"点击了第"+index,Toast.LENGTH_SHORT).show();


        foritem3.setList(friendOBase.getList());
        foritem3.notifyDataSetChanged();


        ll_input.setVisibility(View.VISIBLE);
        this.position = index;
    }

    @Override
    public void onredZan(int index, boolean flag) {
        MessageBase messageBase = friendOBase.getList().get(index);
        messageBase.setRedZan(flag);
        //Toast.makeText(Publicservice2.this,"点击了第"+index,Toast.LENGTH_SHORT).show();

        foritem3.setList(friendOBase.getList());
        foritem3.notifyDataSetChanged();

        this.position= index;




    }

    //    @Override
//    public void onComment(int index) {
//        Toast.makeText(Publicservice2.this,"点击了第"+index,Toast.LENGTH_SHORT).show();
//        ll_input.setVisibility(View.VISIBLE);
//        this.position = index;
//
//        }
        public void OnSend(View view){
            //封装commentBase评论基类
            CommentBase commentBase = new CommentBase();
            commentBase.setMsg(et_input.getText().toString());
            //将新增加的评论插入到数据源的第position个位子的消息的评论
            List<CommentBase> list_comment = friendOBase.getList().get(position).getList();
            list_comment.add(0,commentBase);

            foritem3.setList(friendOBase.getList());
            foritem3.notifyDataSetChanged();
            //情况输入内容
            et_input.setText("");
            //隐藏输入布局
            ll_input.setVisibility(View.GONE);

        }
}
