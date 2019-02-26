package com.example.maibenben.user;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.maibenben.user.what;
//import com.example.administrator.user.what;
public class changename extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changename);
        EditText xiuming = (EditText) findViewById(R.id.xiuming);
        Button savename = (Button) findViewById(R.id.savename);


        xiuming.setText(getIntent().getStringExtra("name"));
    }



public void savename(View View){
    EditText xiuming = (EditText) findViewById(R.id.xiuming);
    Intent intent=new Intent();
    intent.putExtra("name",xiuming.getText().toString());
    setResult(2,intent);

    finish();//这个是说
    //我完成了这个点击事件里面的所有东西
    //然后我们可以返回
}


}
