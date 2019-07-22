package com.stackroute.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTransactionDemo {
    public void getJdbcTransaction()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/example", "root", "Root@123");
             Statement statement = connection.createStatement();)
        {
            connection.setAutoCommit(false);
            statement.executeUpdate("insert into employee values(10,'shanmu','female',24)");
            statement.executeUpdate("insert into employee values(12,'john','male',26)");
            connection.commit();
        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
