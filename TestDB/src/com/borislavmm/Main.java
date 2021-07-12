package com.borislavmm;

import java.sql.*;
import java.util.Collection;

public class Main {

    public static final String DB_NAME = "testjava.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\bmintchev\\IdeaProjects\\TestDB\\" + DB_NAME;

    public static final String TABLE_CONTACTS = "contacts";

    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";



    public static void main(String[] args) {
        try{
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            //conn.setAutoCommit(false);
            Statement statement = conn.createStatement();
            statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS +
                                " (" +  COLUMN_NAME + " text, " +
                                        COLUMN_PHONE + " integer, " +
                                        COLUMN_EMAIL + " textx" + ")");

            inseertContacts(statement, "Bobby", 654321, "bobby@email.com");
            inseertContacts(statement, "Joe", 123456, "joe@emil.com");
            inseertContacts(statement, "Jane", 876543232, "jane@emil.com");
            inseertContacts(statement, "Fido", 918273645, "doggo@emil.com");


            statement.execute("UPDATE " + TABLE_CONTACTS + " SET " +
                                COLUMN_PHONE + " = 53333 " +
                                " WHERE " + COLUMN_NAME + " ='Jane' ");

            statement.execute("DELETE FROM " + TABLE_CONTACTS +
                                " WHERE " + COLUMN_NAME + "='Joe'");

            ResultSet result = statement.executeQuery("SELECT * FROM " + TABLE_CONTACTS );
            while (result.next()){
                System.out.println(result.getString(COLUMN_NAME) + " " +
                        result.getInt(COLUMN_PHONE) + " " +
                        result.getString(COLUMN_EMAIL));
            }
            result.close();
            statement.close();
            conn.close();
        }catch (SQLException e) {
            System.out.println("Something went wrong" + e.getMessage());
            e.printStackTrace();
        }

    }

    public static void inseertContacts(Statement statement, String name, int phone, String email) throws SQLException {
        statement.execute("INSERT INTO " + TABLE_CONTACTS +
                " (" + COLUMN_NAME + ", " +
                COLUMN_PHONE + ", " +
                COLUMN_EMAIL + ")" +
                "VALUES('" + name + "', " + phone + ", '" + email + "')");
    }
}
