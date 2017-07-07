package com.kodeir.kcommons.database;

import java.io.File;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DefaultDatabaseH2 extends DefaultDatabase implements DatabaseH2 {

    private String dbUrl = "jdbc:h2:."+File.separator+"data"+ File.separator;
    private String dbUrlCrypt = ";CIPHER=AES";
    private String dbUrlExists = ";IFEXISTS=TRUE";

    @Override
    public boolean setConnectionIfDbExist(String database, String user, String password) {
        try {
            connection = DriverManager.getConnection(dbUrl + database + dbUrlCrypt + dbUrlExists, user, password);
            return true;
        } catch (SQLException e) {
            catchSqlE(e, database, user);
            return false;
        }
    }

    @Override
    public boolean setConnection(String database, String user, String password){
        try {
            connection = DriverManager.getConnection(dbUrl + database + dbUrlCrypt, user, password);
            return true;
        } catch (SQLException e) {
            catchSqlE(e, database, user);
            return false;
        }
    }

    private void catchSqlE(SQLException e, String database, String user){
        System.out.println(e.getMessage());
        printSqlException(e, "Failed to open connection to " + database + " with user = " + user + "!");
    }
}
