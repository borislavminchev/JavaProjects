package com.borislavmm;

import static com.borislavmm.ThreadColor.ANSI_RED;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(ANSI_RED + "hello from myRunnable");
    }

}
