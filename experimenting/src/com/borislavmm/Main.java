package com.borislavmm;

import com.borislavmm.Triangle;

import java.io.*;
import java.math.*;
import java.security.*;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    public static List<String> triangleType(List<String> triangleToy) {

        return triangleToy.stream()
                .map(i -> Arrays.stream(i.split(" "))
                        .collect(Collectors.toList()))
                .map(Triangle::new)
                .map(Triangle::determineType)
                .collect(Collectors.toList());
    }
}




public class Main {
    public static void main(String[] args) throws IOException {
        ResultSet rs = null;
        rs.updateTimestamp("aaaaaa", Timestamp.valueOf());
    }
}