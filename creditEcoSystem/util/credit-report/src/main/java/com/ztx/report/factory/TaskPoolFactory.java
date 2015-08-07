package com.ztx.report.factory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TaskPoolFactory {
	private static LinkedBlockingQueue<Runnable> queue = null;
    
    private static ThreadPoolExecutor pool = null;  
    
    private TaskPoolFactory(){ }
    
    public static ThreadPoolExecutor getTaskPool(int corePoolSize,
            int maximumPoolSize,
            long keepAliveMinutes,int queueSize){
    	if(queue == null && pool == null){
    		queue = new LinkedBlockingQueue<Runnable>();
        	pool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveMinutes, TimeUnit.MINUTES, queue, new ThreadPoolExecutor.CallerRunsPolicy()); 
    	}else{
    		return pool;
    	}
    	
    	return pool;
    }
}
