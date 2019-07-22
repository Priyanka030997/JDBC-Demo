package com.stackroute.jdbc;

import java.sql.*;

public class ResultSetMetadataDemo {


    public void getResultSet() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/example", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from employee");) {

             ResultSetMetaData resultSetMetadata = resultSet.getMetaData();
            System.out.println("No of columns: " + resultSetMetadata.getColumnCount() + " Column Name: " + resultSetMetadata.getColumnName(1) + " ColumnType: " + resultSetMetadata.getColumnTypeName(1));

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}

