package com.stackroute.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseMetadataDemo {
    public void getdatabaseMetadata()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/example", "root", "Root@123");)
        {
            DatabaseMetaData dbmd=connection.getMetaData();
            System.out.println("Driver Name: "+dbmd.getDriverName()+" Driver Version: "+dbmd.getDriverVersion()+" User Name: "+dbmd.getUserName());
        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
