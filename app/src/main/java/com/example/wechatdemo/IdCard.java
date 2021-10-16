package com.example.wechatdemo;

public class IdCard {
        public int imageid; // 头像id
        public String name; //昵称
        public String time; //时间
        public IdCard(){
                this.imageid=imageid;
                this.name=name;
                this.time=time;
        }
        public String getName(){
                return name;
        }
        public int getImageid(){
                return imageid;
        }
        public String getTime(){return time;}
}
