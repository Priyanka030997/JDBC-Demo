package com.stackroute.jdbc;

import java.sql.ResultSetMetaData;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SimpleJdbcDemo simpleJdbcDemo = new SimpleJdbcDemo();
        simpleJdbcDemo.getEmployeeDetails();
        simpleJdbcDemo.getEmployeeDetailsInReverse();
        simpleJdbcDemo.getEmployeeDetailsFromSecondRowInReverse();
        simpleJdbcDemo.getEmployeeDetailsByNameAndGender("priya","female");
        RowSetDemo rowSetDemo=new RowSetDemo();
        rowSetDemo.getRowSet();
        ResultSetMetadataDemo resultSetMetadataDemo=new ResultSetMetadataDemo();
        resultSetMetadataDemo.getResultSet();
        DatabaseMetadataDemo databaseMetadataDemo=new DatabaseMetadataDemo();
        databaseMetadataDemo.getdatabaseMetadata();
        JdbcBatchDemo jdbcBatchDemo=new JdbcBatchDemo();
        jdbcBatchDemo.getJdbcBatch();
        JdbcTransactionDemo jdbcTransactionDemo=new JdbcTransactionDemo();
        jdbcTransactionDemo.getJdbcTransaction();
    }
}
