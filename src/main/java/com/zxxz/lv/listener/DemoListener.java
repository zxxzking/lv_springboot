package com.zxxz.lv.listener;

import java.util.EventListener;

/**
 * 监听器接口
 */
public interface DemoListener extends EventListener{
    public void demoEvent(DemoEvent event);
}
