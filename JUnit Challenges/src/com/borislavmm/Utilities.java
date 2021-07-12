package com.borislavmm;

public class Utilities {


    public char[] everyNthChar(char[] sourceArray, int n) {
        if(sourceArray == null || sourceArray.length<n || n<=0) {
            return sourceArray;
        }

        int returnedLength = sourceArray.length/n;
        char[] result = new char[returnedLength];
        int index = 0;

        for (int i = n-1; i<sourceArray.length; i += n) {
            result[index++] = sourceArray[i];
        }

        return result;
    }

    public String removePairs(String source) {
        if(source == null || source.length() < 2) {
            return source;
        }

        StringBuilder sb = new StringBuilder();
        char[] string = source.toCharArray();
        for (int i = 0; i < string.length-1; i++) {
            if (string[i] != string[i + 1]) {
                sb.append(string[i]);
            }
        }
        sb.append(string[string.length - 1]);

        return sb.toString();
    }

    public int converter(int a, int b) {
//        if (b == 0) {
//            return 0;
//        }
        return (a/b) + (a*30) - 2;
    }

    public String nullIfOddLength(String source) {
        if(source.length() % 2 == 0) {
            return source;
        }
        return null;
    }
}
