package com.pig.design.obsever;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class Observable {

    private static final ExecutorService EXECUTOR = Executors.newSingleThreadExecutor();

    private final List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void removeObserver(Observer observer){
        observers.remove(observer);
    }


    public void notifyObservers(String msg){
        observers.forEach(observer -> observer.doSth(msg));
    }

    public void asyncNotifyObservers(String msg){
        observers.forEach(observer -> {
            EXECUTOR.submit(() ->
                    observer.doSth(msg));
        });
    }
}
