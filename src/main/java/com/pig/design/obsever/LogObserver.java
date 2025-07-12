package com.pig.design.obsever;

import cn.hutool.core.util.StrUtil;

public class LogObserver implements  Observer{

    @Override
    public void doSth(String msg){
        String s = StrUtil.format("日志观察者收到消息 {} , 记录日志", msg);
        System.out.println(s);
    }
}
