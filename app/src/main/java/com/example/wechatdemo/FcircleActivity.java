package com.example.wechatdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.widget.Adapter;

import java.util.ArrayList;

public class FcircleActivity extends AppCompatActivity {
    private RecyclerView recyclerView;//声明RecyclerView
    private FcircleAdapter fcircleAdapter;
    private Context context;
    ArrayList<FcircleCard> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        context = this;
        setContentView(R.layout.activity_fcircle);
        recyclerView = (RecyclerView) findViewById(R.id.RecyclerView_fcircle);
        //初始化数据
        initView();
        //适配器实例化
        fcircleAdapter = new FcircleAdapter(context,list);
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(fcircleAdapter);
        //给recyclerView设置水平分割线
        recyclerView.addItemDecoration(new DividerItemDecoration(context,DividerItemDecoration.HORIZONTAL_LIST,5,0xCCCCCCFF));
    }
    private void initView(){
        String[] name={"小马","小丁"};
        String[] text={"哈哈哈哈哈","芜湖芜湖"};
        int[] touxiangid={R.drawable.photo_p1,R.drawable.photo_p2};
        int[] pictureid={R.drawable.photo_p3,R.drawable.photo_p4};
        for(int j=0;j<2;j++){
            for(int i=0;i<2;i++){
                FcircleCard fcircleCard=new FcircleCard();
                fcircleCard.name=name[i];
                fcircleCard.text=text[i];
                fcircleCard.touxiangid=touxiangid[i];
                fcircleCard.pictureid=pictureid[i];
                list.add(fcircleCard);
            }
        }
    }
}