package com.yu.algorithms.alibaba;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.LockSupport;

/**
 * 线程间通信
 *
 */
public class Foo {



    private volatile int sign=1;
    public Foo() {

    }

    Map<Integer, Thread> temp = new ConcurrentHashMap<>();


    // 132
    public void  first(Runnable printFirst) throws InterruptedException {


        temp.put(1, Thread.currentThread());
        while (sign != 1){
            LockSupport.park();
        }

        printFirst.run();
        sign ++;
        LockSupport.unpark(temp.get(2));


    }

    public  void second(Runnable printSecond) throws InterruptedException {

        temp.put(2, Thread.currentThread());

        while (sign != 2){
            LockSupport.park();
        }

        printSecond.run();

        sign++;

        LockSupport.unpark(temp.get(3));

    }

    public  void third(Runnable printThird) throws InterruptedException {

        temp.put(3, Thread.currentThread());

        while (sign != 3){
            LockSupport.park();
        }
        printThird.run();
        sign = 1;
        LockSupport.unpark(temp.get(1));

    }







}
