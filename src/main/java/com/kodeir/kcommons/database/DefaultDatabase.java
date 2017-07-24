package com.kodeir.kcommons.database;

import com.kodeir.kcommons.log.KLogger;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DefaultDatabase implements Database{

    private static final Logger logger = new KLogger(DefaultDatabase.class.getName());

    Connection connection = null;
    private Statement statement = null;

    @Override
    public boolean setConnection(String dbUrl, String user, String password) {
        try {
            connection = DriverManager.getConnection(dbUrl, user, password);
            return true;
        } catch (SQLException e) {
            return printSqlException(e, "Failed to open connection to " + dbUrl + " with user = " + user + "!");
        }
    }

    @Override
    public boolean closeConnection() {
        closeStatement();
        try{
            if (connection != null) {
                connection.close();
                logger.log(Level.FINE, "Connection was closed successfully.");
                return true;
            } else {
                logger.log(Level.FINE, "Connection was not opened.");
                return true;
            }
        } catch (SQLException e){
            return printSqlException(e, "Failed to close a connection.");
        }
    }

    @Override
    public boolean setStatement() {
        try {
            statement = connection.createStatement();
            return true;
        } catch (SQLException e) {
            return printSqlException(e, "Failed to create a statement.");
        }
    }

    @Override
    public boolean closeStatement() {
        try{
            if (statement != null) {
                statement.close();
                logger.log(Level.FINE, "Statement was closed successfully.");
                return true;
            } else {
                logger.log(Level.FINE, "Statement was not opened.");
                return true;
            }
        } catch (SQLException e){
            return printSqlException(e, "Failed to close a statement.");
        }
    }

    @Override
    public boolean runExecuteUpdateQuery(String sql) {
        try {
            statement.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            return printSqlException(e, "ExecuteUpdateQuery failed");
        }
    }

    @Override
    public boolean runExecute(String sql) {
        try {
            statement.execute(sql);
            return true;
        } catch (SQLException e) {
            return printSqlException(e, "ExecuteQuery failed");
        }
    }

    @Override
    public ResultSet runSelectQuery(String sql) {
        try {
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            printSqlException(e, "SelectQuery failed");
            return null;
        }
    }

    @Override
    public boolean connectionIsNull() {
        return connection == null;
    }

    @Override
    public boolean statementIsNull() {
        return statement == null;
    }

    @Override
    public boolean commit() {
        try {
            connection.commit();
            return true;
        } catch (SQLException e) {
            return printSqlException(e, "Commit failed");
        }
    }

    protected boolean printSqlException(SQLException e, String message){
        logger.log(Level.SEVERE, message
                        + "\n"
                        + "Error code: " + e.getErrorCode()
                        + "\n"
                        + e.getMessage()
                        + "\n"
                , e);
        return false;
    }
}
