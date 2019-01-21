package com.stackroute.services;

import java.sql.*;

public class DatabaseConnection {
        Login log;
        private Connection con;

        public void InsertData(String username, String password) {
            try {
                //Resister Driver with driver manager service
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("Driver loaded");

                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student", "user", "hima");
                //create statement object
                System.out.println("got connected");
                //PreparedStatement
                String query = " insert into student (name,password) values (?,?)";
                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = con.prepareStatement(query);
                preparedStmt.setString(1, username);
                preparedStmt.setString(2, password);
                // execute the preparedstatement
                preparedStmt.execute();

            } catch (Exception e) {
                System.out.println(e);
            } finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }

    public void showdata() {
        try {
            //Resister Driver with driver manager service
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student", "user", "hima");
            //create statement object
            System.out.println("got connected");
            //PreparedStatement
            String query = "select * from student";

            Statement statement = con.createStatement();
            ResultSet resultSet=statement.executeQuery(query);

                while (resultSet.next()){
                    System.out.println(resultSet.getString("name"+" "+resultSet.getString("password")));
                }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    }
