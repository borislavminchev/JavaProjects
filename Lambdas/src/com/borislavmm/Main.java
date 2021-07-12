package com.borislavmm;

import javax.xml.catalog.Catalog;
import java.util.*;

public class Main {

    public static void main(String[] args) {

       Employee john = new Employee("John", 32);
       Employee tim = new Employee("tim", 21);
       Employee jack = new Employee("Jack", 51);
       Employee snow = new Employee("Snow", 42);

       List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);


        Collections.sort(employees, Comparator.comparing(employee1 -> employee1.getName()));
        for(Employee employee : employees) {
            System.out.println(employee.getName());
            new Thread(()->{
                System.out.println(employee.getAge());
            }).start();
        }
        System.out.println("_________________________________");
//        for (int i = 0; i < employees.size(); i++) {
//            Employee employee = employees.get(i);
//            System.out.println(employee.getName());
//            new Thread(()->{
//                System.out.println(employee.getAge());
//            }).start();
//        }

        employees.forEach((e)->{
            System.out.println(e.getName());
        });
    }

    public static String doStringStuff(UpperConcat uc, String s1, String s2){
        return uc.upperAndConcat(s1, s2);
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

interface UpperConcat {
    public String upperAndConcat(String s1, String s2);
}

class AnotherClass {
    public String doSomething() {
        final int i = 0;


        UpperConcat uc = (s1, s2) -> {
            System.out.println("the lambda class name is " + getClass().getSimpleName());
            System.out.println("i in the lambda expression is " + i);
            String res = s1.toUpperCase() + s2.toUpperCase();
            return res;
        };



        System.out.println("the AnotherClass name is " + getClass().getSimpleName());
        return Main.doStringStuff(uc, "stings", "string2");
    }

    public void printValue(){
        int number = 25;
        Runnable r = () -> {
            try{
                Thread.sleep(5000);

            } catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("The value is " + number);

        };
        new Thread(r).start();
    }
}

