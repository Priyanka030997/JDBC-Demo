package com.stackroute.jdbc;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class SimpleJdbcDemo {

    private Connection connection;
    private  Statement statement;
    private ResultSet resultSet;
    public void getEmployeeDetails() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/example", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from employee");)
        {
            /*Load driver and register with DriverManager*/

            /*Use DriverManager to get Connection*/
            //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "Root@123");

//             statement = connection.createStatement();
//
//             resultSet = statement.executeQuery("Select * from employee");

            while (resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
           ex.printStackTrace();
        }
//        finally {
//            try {
//                connection.close();
//                statement.close();
//                resultSet.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }

        }


    /*Print ResultSet in reverse order*/
    public void getEmployeeDetailsInReverse() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/example", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from employee");)
        {
            resultSet.afterLast();
            System.out.println("Employee Details in reverse order:");
            while(resultSet.previous())
            {
                System.out.println("Id: "+resultSet.getInt(1)+" Name: "+resultSet.getString(2)+" Gender: "+resultSet.getString(3)+" Age: "+resultSet.getInt(4));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    /*Move ResultSet to second row and print in reverse order*/
    public void getEmployeeDetailsFromSecondRowInReverse() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/example", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from employee");)
        {
            resultSet.absolute(2);
            System.out.println("Employee details from second row in reverse order:");
            System.out.println("Id: "+resultSet.getInt(1)+" Name: "+resultSet.getString(2)+" Gender: "+resultSet.getString(3)+" Age: "+resultSet.getInt(4));
            while(resultSet.previous())
            {
                System.out.println("Id: "+resultSet.getInt(1)+" Name: "+resultSet.getString(2)+" Gender: "+resultSet.getString(3)+" Age: "+resultSet.getInt(4));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Use PreparedStatement to display by name and gender

    public void getEmployeeDetailsByNameAndGender(String name,String gender) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/example", "root", "Root@123");
             PreparedStatement statement = connection.prepareStatement("select *from employee where empName=? and gender=?");)
           // ResultSet resultSet = statement.executeQuery("Select * from employee");)

        {
            statement.setString(1,name);
            statement.setString(2,gender);
            ResultSet resultSet=statement.executeQuery();
            System.out.println("Employee details display by name and gender using prepared statement:");
            while(resultSet.next())
            {
                System.out.println("Id: "+resultSet.getInt(1)+" Name: "+resultSet.getString(2)+" Gender: "+resultSet.getString(3)+" Age: "+resultSet.getInt(4));
                //System.out.println("Name: "+resultSet.getInt(2)+" Gender: "+resultSet.getInt(3));
            }
        }

            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
