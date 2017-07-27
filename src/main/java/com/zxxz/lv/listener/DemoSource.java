package com.zxxz.lv.listener;

import java.io.File;
import java.util.Enumeration;
import java.util.Vector;

/**
 * 使用事件的类
 */
public class DemoSource {
    private Vector repository = new Vector();
    private DemoListener dl;
    private String sName="";
    private final File file = new File("D:/idea_workspace/log/zxxz.txt");



    public DemoSource() {
    }

    public void addDemoListener(DemoListener dl){
        repository.add(dl);
    }

    /**
     * 通知事件处理
     * @param event
     */
    public void notifyDemoEvent(DemoEvent event) {
        Enumeration enums = repository.elements();//这步要注意同步问题
        while(enums.hasMoreElements()){
            dl = (DemoListener)enums.nextElement();
            dl.demoEvent(event);
        }
    }
    //删除监听器，如果这里没有使用Vector而是使用ArrayList那么要注意同步问题
    public void removeDemoListener(DemoListener dl){
        repository.remove(dl);//这步要注意同步问题
    }


    public void setName(String str1){
        boolean bool=false;
        if(str1==null && sName!=null) {
            bool = true;
        }else if(str1!=null && sName==null) {
            bool=true;
        }else if(!sName.equals(str1)) {
            bool=true;
        }
        this.sName=str1;
        //如果改变则执行事件
        if(bool) {
            notifyDemoEvent(new DemoEvent(this,sName));
        }
    }

    public String getName()
    {
        return sName;
    }
}
