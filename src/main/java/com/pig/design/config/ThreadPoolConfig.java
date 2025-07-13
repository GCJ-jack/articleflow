package com.pig.design.config;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
@Configuration
public class ThreadPoolConfig {

    // private static final int CPU_NUM = Runtime.getRuntime().availableProcessors();
    // io密集型任务定义
    // private static final int MAX_POOL_SIZE = CPU_NUM * 2;
    // cpu密集型任务定义
    // private static final int MAX_POOL_SIZE = CPU_NUM + 1;


    public static final String EVENT_THREAD_POOL = "EVENT_THREAD_POOL";

    @Bean(EVENT_THREAD_POOL)
    public ThreadPoolExecutor eventTHreadPool(){
        return  new ThreadPoolExecutor(
                3,
                5,
                30,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1024)
        );
    }
}
