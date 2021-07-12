package com.borislavmm;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> someBIngoNumbers = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53", "G49", "G60", "G50", "g64",
                "I26", "I17", "I29",
                "079");
//        List<String> gNumbers = new ArrayList<>();
//        someBIngoNumbers.forEach(number ->{
//            if(number.toUpperCase().startsWith("G")){
//                gNumbers.add(number);
////                System.out.println(number);
//            }
//        });
//        gNumbers.sort((String s1, String s2) ->{
//            return s1.compareTo(s2);
//        });
//        gNumbers.forEach((String s)->{
//            System.out.println(s);
//        });
        someBIngoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .forEach(System.out::println);

        Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "079");
        Stream<String> inNUmberStream = Stream.of("N40", "N36", "I26", "I17", "I29", "079");
        Stream<String> concatStream = Stream.concat(ioNumberStream,inNUmberStream);
        System.out.println(concatStream.distinct().peek(System.out::println).count());

        Employee john = new Employee("John Jo.", 20);
        Employee jack = new Employee("Jack Ja.", 31);
        Employee jane = new Employee("Jane Ja.", 45);
        Employee snow = new Employee("Snow S.", 14);

        Department hr = new Department("Human Resources");
        hr.addEmployee(jane);
        hr.addEmployee(jack);
        hr.addEmployee(snow);
        Department accounting = new Department("Accounting");
        accounting.addEmployee(john);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);

        System.out.println("________________________________");

        List<String> sortedGNumbers = someBIngoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        for (String s : sortedGNumbers) {
            System.out.println(s);
        }

        Map<Integer, List<Employee>> goupedByAge = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(employee -> employee.getAge()));

        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2)
                .ifPresent(System.out::println);


        Supplier<String> supplier = () -> {
            return "hello world";
        };

    }
}
