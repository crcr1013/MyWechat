package com.example.wechatdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class friendsAdapter extends RecyclerView.Adapter<friendsAdapter.MyViewHolder> {
    private Context context;
    public  View itemView;
    ArrayList<IdCard> list=new ArrayList<>();


    public friendsAdapter(Context context, ArrayList<IdCard> list){
        this.context=context;
        this.list=list;
    }
    public friendsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        itemView= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(itemView);
        return myViewHolder;
    }

    /**
     * 将数据与 item 视图进行绑定
     */
    @Override
    public void onBindViewHolder(@NonNull friendsAdapter.MyViewHolder holder, int position) {
        IdCard idcard = list.get(position);
        holder.textView1.setText(idcard.name);
        holder.imageView1.setImageResource(idcard.getImageid());
//        holder.textView2.setText(list.get(position));
//        holder.textView3.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView1,textView2,textView3;
        ImageView imageView1;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1=itemView.findViewById(R.id.textViewfriends);
            imageView1=itemView.findViewById(R.id.imageViewfirends);
//            textView2=itemView.findViewById(R.id.textView2);
//            textView3=itemView.findViewById(R.id.textView3);
        }
    }
}
