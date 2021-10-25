package com.example.wechatdemo;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;

public class weixinFragment extends Fragment implements IMoveAndSwipeCallback{
    private RecyclerView recyclerView;//声明RecyclerView
    private weixinAdapter weixinAdapter;
    private Context context;
    ArrayList<IdCard> list=new ArrayList<>();

    public weixinFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_weixin,container,false);
        super.onCreate(savedInstanceState);
        context = this.getActivity();
        recyclerView = view.findViewById(R.id.RecyclerView);
        //初始化数据
        initView();
        //适配器实例化，设置纵向布局
        weixinAdapter = new weixinAdapter(context,list);
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(weixinAdapter);
        //给recyclerView设置水平分割线
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.BOTH_SET,5,0xCCCCCCFF));
        //给recyclerView设置ItemTouchHelper
        ItemTouchHelperCallback itemTouchHelperCallback = new ItemTouchHelperCallback();
        itemTouchHelperCallback.setiMoveAndSwipeCallback(this);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemTouchHelperCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

        return view;
    }
    //上下拖拽函数
    @Override
    public void onMove(int prePosition, int postPosition) {
        Collections.swap(list, prePosition, postPosition);
        if (recyclerView.getAdapter() != null) {
            recyclerView.getAdapter().notifyItemMoved(prePosition, postPosition);
        }
    }
    //左滑删除函数
    @Override
    public void onSwiped(int position) {
        list.remove(position);
        if (recyclerView.getAdapter() != null) {
            recyclerView.getAdapter().notifyItemRemoved(position);
        }
    }
    //初始化文本和图片数据函数
    private void initView(){
        String[] name={"小马","小丁","小刘","小宋","小张","小贺","小严"};
        String[] time={"22:14","22:01","22:00","21:47","21:40","21:36","21:30"};
        int[] imageid={R.drawable.photo_p1,R.drawable.photo_p2,R.drawable.photo_p3,
                R.drawable.photo_p4,R.drawable.photo_p5,R.drawable.photo_p6,R.drawable.photo_p7};
        //设置两个循环体传递数据
        for (int m=0;m<2;m++){
            for (int i=0;i<7;i++){
                IdCard idcard = new IdCard();
                idcard.name=name[i];
                idcard.time=time[i];
                idcard.imageid=imageid[i];
                list.add(idcard);
            }
        }
    }
}