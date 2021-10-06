package com.example.wechatdemo;

import android.app.Activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {
    private weixinFragment weixinFragment = new weixinFragment();
    private friendsFragment friendsFragment = new friendsFragment();
    private findFragment findFragment = new findFragment();
    private shezhiFragment shezhiFragment = new shezhiFragment();
    private FragmentManager fragmentManager;
    private View LinearLayout1,LinearLayout2,LinearLayout3,LinearLayout4;
    private TextView textView1,textView2,textView3,textView4;
    private ImageView image1,image2,image3,image4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        LinearLayout1 = findViewById(R.id.LinearLayout_weixin);
        LinearLayout2 = findViewById(R.id.LinearLayout_friends);
        LinearLayout3 = findViewById(R.id.LinearLayout_find);
        LinearLayout4 = findViewById(R.id.LinearLayout_shezhi);

        textView1=findViewById(R.id.textView);
        textView2=findViewById(R.id.textView);
        textView3=findViewById(R.id.textView);
        textView4=findViewById(R.id.textView);

        image1=findViewById(R.id.imageView1);
        image2=findViewById(R.id.imageView2);
        image3=findViewById(R.id.imageView3);
        image4=findViewById(R.id.imageView4);

        LinearLayout1.setOnClickListener(this);
        LinearLayout2.setOnClickListener(this);
        LinearLayout3.setOnClickListener(this);
        LinearLayout4.setOnClickListener(this);
        initFragment();
        showFragment(0);

    }

    private void initFragment(){
        fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.content,weixinFragment);
        transaction.add(R.id.content,friendsFragment);
        transaction.add(R.id.content,findFragment);
        transaction.add(R.id.content,shezhiFragment);
        transaction.commit();
    }

    public void hideFragment(FragmentTransaction transaction){
        transaction.hide(weixinFragment);
        transaction.hide(friendsFragment);
        transaction.hide(findFragment);
        transaction.hide(shezhiFragment);
    }

    private void resetImgs(){
        image1.setImageResource(R.drawable.p1);
        image2.setImageResource(R.drawable.p2);
        image3.setImageResource(R.drawable.p3);
        image4.setImageResource(R.drawable.p4);
    }

    private void showFragment(int i){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragment(transaction);
        switch (i){
            case 0:
                transaction.show(weixinFragment);
                image1.setImageResource(R.drawable.p1_color);
                textView1.setText("聊天");
                break;
            case 1:
                transaction.show(friendsFragment);
                image2.setImageResource(R.drawable.p2_color);
                textView2.setText("朋友");
                break;
            case 2:
                transaction.show(findFragment);
                image3.setImageResource(R.drawable.p3_color);
                textView3.setText("发现");
                break;
            case 3:
                transaction.show(shezhiFragment);
                image4.setImageResource(R.drawable.p4_color);
                textView4.setText("设置");
                break;
            default:
                break;
        }
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        resetImgs();
        switch (v.getId()){
            case R.id.LinearLayout_weixin:
                showFragment(0);
                break;
            case R.id.LinearLayout_friends:
                showFragment(1);
                break;
            case R.id.LinearLayout_find:
                showFragment(2);
                break;
            case R.id.LinearLayout_shezhi:
                showFragment(3);
                break;
            default:
                break;
        }
    }
}
