package com.example.wechatdemo;

 //拖拽和侧滑抽象接口
public interface IMoveAndSwipeCallback {
    void onMove(int prePosition, int postPosition);

    void onSwiped(int position);
}
