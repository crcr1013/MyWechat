package com.example.wechatdemo;

import android.content.Context;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class weixinAdapter extends RecyclerView.Adapter<weixinAdapter.MyViewHolder> {
    private Context context;
    public  View itemView;
    ArrayList<IdCard> list=new ArrayList<>();//使用
    //构造函数
    public weixinAdapter(Context context, ArrayList<IdCard> list){
        this.context=context;
        this.list=list;
    }
    //创建ViewHolder,返回每一项的布局
    public weixinAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        itemView= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(itemView);
        return myViewHolder;
    }
    //将数据与 item 视图进行绑定
    @Override
    public void onBindViewHolder(@NonNull weixinAdapter.MyViewHolder holder, int position) {
        IdCard idcard = list.get(position);
        //绑定item每一个控件对应的数据
        holder.textView1.setText(idcard.name);//文本一昵称
        holder.imageView1.setImageResource(idcard.getImageid());//图像Id
        holder.textView3.setText(idcard.time);//文本三时间
        //给item设置点击事件
        holder.Clickitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "你点击的是"+idcard.name+"的信息！",Toast.LENGTH_SHORT).show();
            }
        });
    }
    //返回item总条数
    @Override
    public int getItemCount() {
        return list.size();
    }
    //内部类，绑定控件
    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView1,textView2,textView3;
        ImageView imageView1;
        View Clickitem;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1=itemView.findViewById(R.id.textViewfriends);
            imageView1=itemView.findViewById(R.id.imageViewfirends);
            textView3=itemView.findViewById(R.id.textViewfriends3);
            Clickitem=itemView.findViewById(R.id.itemlinearlayout);
        }
    }
}
