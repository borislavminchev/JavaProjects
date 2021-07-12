package com.borislavmm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestdbRecord {
    private int id;
    private String fname;
    private String lname;
    private int age;

    public TestdbRecord(int id, String fname, String lname, int age) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.age = age;
    }

    public static Connection establishConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/test";
        Connection connection = DriverManager.getConnection(url, "root", "B21032001pi/6");

        return connection;
    }

    private static boolean exists(TestdbRecord record) throws Exception {
        int recordID = record.getId();

        Connection connection = establishConnection();
        Statement stmt = connection.createStatement();
        String query = "SELECT * FROM test.persons;";
        ResultSet res = stmt.executeQuery(query);

        while (res.next()) {
            if (recordID == res.getInt(1)) {
                return true;
            }
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean addRecord() throws Exception {
        String rID = String.valueOf(this.id);
        String rFname = this.fname;
        String rLname = this.lname;
        String rAge = String.valueOf(this.age);
        Connection connection = establishConnection();
        Statement stmt = connection.createStatement();
        String query = "INSERT INTO test.persons (id, fname, lname, age)\n" +
                "VALUES (" + rID + ",'" + rFname + "','" + rLname + "'," + rAge + ");";
        if (exists(this)) {
            return false;
        }
        int res = stmt.executeUpdate(query);
        return true;
    }

    public boolean removeRecord() throws Exception {
        String rID = String.valueOf(this.id);
        Connection connection = establishConnection();
        Statement stmt = connection.createStatement();
        String query = "DELETE FROM test.persons WHERE id=" + rID + ";";
        if (exists(this)) {
            int res = stmt.executeUpdate(query);
            return true;

        }
        return false;
    }


    public static void printRecords() throws Exception {
        Connection connection = establishConnection();
        Statement stmt = connection.createStatement();
        String query = "SELECT * FROM test.persons;";
        ResultSet res = stmt.executeQuery(query);
        while (res.next()) {
            int id = res.getInt(1);
            String fname = res.getString(2);
            String lname = res.getString(3);
            int age = res.getInt(4);

            System.out.printf("%d | %s | %s | %d\n", id, fname, lname, age);
        }
    }
}










