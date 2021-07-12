package com.borislavmm;

public class Person {

    private String firstName;
    private int age;
    private boolean male;

    public Person(String firstName, int age, boolean male) {
        this.firstName = firstName;
        this.age = age;
        this.male = male;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    @Override
    public String toString() {
        return super.toString();
    }


}
