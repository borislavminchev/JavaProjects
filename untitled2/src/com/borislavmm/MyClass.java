package com.borislavmm;

public class MyClass {
    private static String longestSequence (String input) {
        String longest = String.valueOf(input.charAt(0));
        String current = String.valueOf(input.charAt(0));

        for (int i = 1; i < input.length(); i++) {
            String letter = String.valueOf(input.charAt(i));

            if (String.valueOf(current.charAt(current.length()-1)).equals(letter)) {
                current += letter;
            }else {
                current = letter;
            }

            if (longest.length() < current.length()) {
                longest = current;
            }

        }
        return longest;
    }

    private static void addSpace(String s, String[] dict) {

    }
    public static void main(String[] args) {
        System.out.println(longestSequence("1322452ffffffffffff7373532222222222222"));
        Person person = new Person("pe60", 21, true);
        System.out.println(person);
    }
}

