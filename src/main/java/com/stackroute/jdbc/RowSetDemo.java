package com.stackroute.jdbc;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.SQLException;

public class RowSetDemo {
    public void getRowSet()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // create rowset object
        try {
           JdbcRowSet rowset = RowSetProvider.newFactory().createJdbcRowSet();
            rowset.setUrl("jdbc:mysql://localhost:3306/example"); // connect to database
            rowset.setUsername("root");
            rowset.setPassword("Root@123");
            rowset.setCommand("select * from employee");
            rowset.execute();
            while(rowset.next())
            {
                System.out.println("Id: "+rowset.getInt(1)+" Name: "+rowset.getString(2)+" Gender: "+rowset.getString(3)+" Age: "+rowset.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
