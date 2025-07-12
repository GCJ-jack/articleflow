package com.pig.design.obsever;

import cn.hutool.core.util.StrUtil;

public class MailObserver implements Observer{
    @Override
    public void doSth(String msg){
        String s = StrUtil.format("观察者收到消息 {}, 发送邮件", msg);

        System.out.println(s);
    }
}
