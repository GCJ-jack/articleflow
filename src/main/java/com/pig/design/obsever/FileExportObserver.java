package com.pig.design.obsever;

public class FileExportObserver extends Observable{

    public FileExportObserver(){
        addObserver((new MailObserver()));
    }

    public void export2Db(){
        System.out.println("将文件数据导入到数据库中...");

        asyncNotifyObservers("数据导出完成");
    }
}
