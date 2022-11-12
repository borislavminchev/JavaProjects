package com.borislavmm;

import java.util.Random;

public class Main {

    public static boolean isDivisible(int num, int d) {
        return num % d == 0;
    }

    public static int buildNum(int a, int b, int c, int d, int e) {
        if(a > 9 || b > 9 || c > 9 || d > 9 || e > 9) {
            throw new IllegalArgumentException("Numbers must be digits");
        }

        return a*10000 + b*1000 + c*100 + d*10 + e;
    }

    public static void main(String[] args) {
        int allNums = 0;
        int divisibleNums = 0;

        for (int a = 3; a <= 9; a++) {
            for (int b = 2; b <= 8; b++) {
                for (int c = 4; c <= 9; c++) {
                    for (int d = 1; d <= 6; d++) {
                        for (int e = 6; e <= 9; e++) {
                            allNums++;
                            if(isDivisible(buildNum(a,b,c,d,e), 12)) {
                                divisibleNums++;
                            }
                        }
                    }
                }
            }
        }

        System.out.printf("Probability: %f, all numbers: %d, divisible by 12 numbers: %d ", ((double) divisibleNums ) / allNums,
                allNums,
                divisibleNums);
    }
}
