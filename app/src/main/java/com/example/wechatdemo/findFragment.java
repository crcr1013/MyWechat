package com.example.wechatdemo;

import android.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.app.Fragment;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;

public class findFragment extends Fragment {
    private RecyclerView recyclerView;//声明RecyclerView
    private findAdapter findAdapter;
    private Context context;
    ArrayList<Find_Item> list=new ArrayList<>();
    ArrayList<Intent> intents=new ArrayList<>();

    public findFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_find,container,false);
        super.onCreate(savedInstanceState);
        context = this.getActivity();
        recyclerView = view.findViewById(R.id.RecyclerView_find);
        //初始化数据
        initView();
        //初始化Intent
        initIntent();
        //适配器实例化，设置纵向布局
        findAdapter = new findAdapter(context,list,intents);
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(findAdapter);
        //给recyclerView设置水平分割线
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.HORIZONTAL_LIST,5,0xCCCCCCFF));
        return view;
    }
    private void initView(){
        String name[]={"朋友圈","听一听"};
        int iamgeid[]={R.drawable.findimage1,R.drawable.findimage3};
        //设置循环体传递数据
       for (int i=0;i<2;i++){
                Find_Item find_item=new Find_Item();
                find_item.name=name[i];
                find_item.imageid=iamgeid[i];
                find_item.imageid_jiantou=R.drawable.jiantou;
                list.add(find_item);
            }
    }
    private void initIntent(){
            Intent intent=new Intent(context,FcircleActivity.class);
            intents.add(intent);
            Intent intent1=new Intent(context,ListenActivity.class);
            intents.add(intent1);
    }
}