package com.zxxz.lv.test;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        /*List<String> list = new ArrayList<String>();
        String s = "在中启动线程非常容易，大多数情况下是让一个线程执行完" +
                "自己的任务然后自己停掉。一个线程在未正常结束之前, 被强制终止是很危险" +
                "的事情. 因为它可能带来完全预料不到的严重后果，比如会带着自己所持有着自己所持";
        System.out.println(s.substring(s.length()-2,s.length()));

        for (int i=0;i<100;i++){
            double x = Math.random()*100;
            double y = Math.random()*100;
            double z = Math.random()*100;
            int a = (int) x;
            int b = (int) y;
            int c = (int) z;
            char[] chars = {s.charAt(a),s.charAt(b),s.charAt(c)};
            String  string = new String(chars);
            list.add(string);
        }
        list.remove(1);*/

        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        System.out.println(hour);
    }
}
