package com.borislavmm;

import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String challenge1 = "I want a bike.";
        String challenge2 = "I want a ball.";
        String challenge4 = "Replace all blanks with underscores";

        String regex = "I want a (bike|ball).";
        System.out.println(Pattern.matches(regex, challenge1));
        System.out.println(Pattern.matches(regex, challenge2));
        System.out.println(challenge4.replaceAll("\\s", "_"));

    }
}
