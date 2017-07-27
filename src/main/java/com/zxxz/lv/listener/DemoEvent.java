package com.zxxz.lv.listener;

import java.io.File;
import java.util.EventObject;

/**
 * 事件处理类 继承了事件基类
 */
public class DemoEvent extends EventObject {

    private Object obj;
    private String sName;
    private  final File file  = new File("D:/idea_workspace/log/zxxz.txt");;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public DemoEvent(Object source,String sName) {
        super(source);
        obj = source;
        this.sName = sName;
    }

    public void say(){
        System.out.println("this is say");
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public  File getFile() {
        return file;
    }
}
