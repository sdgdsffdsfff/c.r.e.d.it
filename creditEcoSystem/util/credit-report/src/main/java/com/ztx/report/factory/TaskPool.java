//package com.ztx.report.factory;
//
//import java.util.concurrent.ArrayBlockingQueue;
//import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.ThreadPoolExecutor;
//import java.util.concurrent.TimeUnit;
//
///**
//* 总调度程序 （包括协作生产）
//*
//*/
//public class TaskPool extends Thread {
//        private String poolname;
//        
//        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(3);
//        
//        private ThreadPoolExecutor pool =   new ThreadPoolExecutor(3, 10, 1, TimeUnit.MINUTES, queue, new ThreadPoolExecutor.CallerRunsPolicy()); 
//
//        public TaskPool(String poolname) {
//                this.poolname = poolname;
//        }
//
//        @Override
//        public void run() {
//                System.out.println(poolname + ":池中的当前线程数getPoolSize()=" + pool.getPoolSize());
//                int i = 0;
//                while(true){
//                        int x = pool.getQueue().size();
//                        System.out.println("返回此执行程序使用的任务队列="+pool.getQueue().size());
//                        if(x>=5){
//                                try {
//                                        Thread.sleep(10L);
//                                        continue;
//                                } catch (InterruptedException e) {
//                                        e.printStackTrace();
//                                }
//                        }
//                        System.out.println(poolname + "该加入任务了");            //生产过程
//                        for(int k =i+10;i<k;i++){
//                        			
//                                pool.submit(new MyTask(i));
//                        }
//                }
//        }
//
//        public static void main(String[] args) {
//                 new TaskPool("pool1").start();
//        }
//} 