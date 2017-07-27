package com.zxxz.lv.listener;

import java.io.File;

public class TestDemo implements DemoListener {
    private DemoSource ds;
    @Override
    public void demoEvent(DemoEvent event) {
        File file = event.getFile();
        System.out.println("事件处理方法");
    }

    public static void main(String args[]){
        File file = new File("D:/idea_workspace/log/zxxz.txt");
    }
    public TestDemo() {
        ds = new DemoSource();
        ds.addDemoListener(this);
        System.out.println("添加监听器完毕");
        try {
            Thread.sleep(3000);
            //改变属性,触发事件
            ds.setName("改变属性,触发事件");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        ds.addDemoListener(this);
        System.out.println("添加监听器完毕2");
        try {
            Thread.sleep(3000);
            //改变属性,触发事件
            ds.setName("改变属性,触发事件2");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        ds.removeDemoListener(this);
        System.out.println("添加监听器完毕3");
        try {
            Thread.sleep(3000);
            //改变属性,触发事件
            ds.setName("改变属性,触发事件3");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
