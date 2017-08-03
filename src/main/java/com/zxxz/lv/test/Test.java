package com.zxxz.lv.test;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List random = new ArrayList<Integer>();
        for (int i = 0;i<100;i++){
            random.add(i);
        }
        int length = 10;
        Integer[] test = new Integer[length];
        for (int i=0;i<test.length;i++){
            random.remove(test[i]);
        }

    }
}
