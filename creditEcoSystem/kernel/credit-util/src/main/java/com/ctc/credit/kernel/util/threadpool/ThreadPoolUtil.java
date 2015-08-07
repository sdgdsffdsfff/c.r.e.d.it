package com.ctc.credit.kernel.util.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Logger;

public class ThreadPoolUtil {

	private static volatile ThreadFactory factory = null;

	private static final Lock executorLock = new ReentrantLock(true);
	private static volatile ThreadPoolExecutor threadPool;
	private static final int num = 10;
	public static final Logger log = Logger.getLogger(ThreadPoolUtil.class);

	private void initThreadPool() {
		if (threadPool == null) {
			try {
				threadPool = (ThreadPoolExecutor) Executors
						.newFixedThreadPool(num);
			} catch (Exception e) {
				log.error("");
			}
		}
	}
	
}
