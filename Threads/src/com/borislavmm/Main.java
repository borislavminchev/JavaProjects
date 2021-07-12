package com.borislavmm;

import static com.borislavmm.ThreadColor.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Hello from the main thread");
        final Thread anotherThread = new AnotherThread();
        anotherThread.setName("--another thread--");
        anotherThread.start();

        new Thread(){
            @Override
            public void run() {
                System.out.println(ANSI_GREEN + "hello from the anonymous");
            }
        }.start();

        Thread myRunnableThread = new Thread(new MyRunnable(){
            @Override
            public void run() {
                System.out.println(ANSI_RED + "hello from anonymous class's implementation of run");
                try{
                    anotherThread.join();
                    System.out.println(ANSI_RED + "AnotherThread terminated,ro time out, so i'm running again");
                }catch (InterruptedException e){
                    System.out.println(ANSI_RED + "I couldn't wait after all" );
                }
            }
        });

        myRunnableThread.start();

        System.out.println(ANSI_PURPLE + "hello again from the main thread");
    }
}
