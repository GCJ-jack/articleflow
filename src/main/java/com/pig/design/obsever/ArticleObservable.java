package com.pig.design.obsever;

public class ArticleObservable extends Observable{

    public ArticleObservable(){
        addObserver((new MailObserver()));
    }

    public void publish(){
        System.out.println("文章提交审批。。。");
        asyncNotifyObservers("需要审批了");
    }
}
