package com.borislavmm;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record Triangle(int a, int b, int c) {

    public Triangle(String sideA, String sideB, String sideC) {
        this(Integer.parseInt(sideA), Integer.parseInt(sideB), Integer.parseInt(sideC));
    }

    public Triangle(List<String> sides) {
        this(sides.get(0), sides.get(1), sides.get(2));
    }

    private boolean isValid() {

        return (a + b > c) &&
                (c + a > b) &&
                (b + c > a);
    }

    public String determineType() {
        if(!isValid()) {
            return "None of these";
        }

        long cnt = Stream.of(a, b, c).distinct().count();
        return switch (String.valueOf(cnt)) {
            case "1" -> "Equilateral";
            case "2" -> "Isosceles";
            case "3" -> "None of these";
        };

    }
}
