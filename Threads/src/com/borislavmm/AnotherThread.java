package com.borislavmm;

import static com.borislavmm.ThreadColor.*;

public class AnotherThread extends Thread{
    @Override
    public void run() {
        System.out.println(ANSI_BLUE + "hello from " + currentThread().getName());
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            System.out.println(ANSI_BLUE + "another thread woke me up");
            return;
        }

        System.out.println(ANSI_BLUE + "three seconds have passed and i'm awake");
    }
}
