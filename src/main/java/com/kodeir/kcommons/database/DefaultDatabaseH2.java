package com.kodeir.kcommons.database;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DefaultDatabaseH2 extends DefaultDatabase implements DatabaseH2 {

    private final String h2Url = "jdbc:h2:";
    private final String h2UrlCrypt = ";CIPHER=";
    private final String h2UrlExists = ";IFEXISTS=TRUE";

    @Override
    public boolean setConnectionIfDbExist(String database, String user, String password, boolean exists, String encryption) {
        try {
            String url;
            if (encryption.equals("")){
                url = h2Url + database;
            } else {
                url = h2Url + database + h2UrlCrypt + encryption;
            }
            if (exists) {
                connection = DriverManager.getConnection(url + h2UrlExists, user, password);
            } else {
                connection = DriverManager.getConnection(url, user, password);
            }
            return true;
        } catch (SQLException e) {
            printSqlException(e, "Failed to open connection to " + database + " with user = " + user + "!");
            return false;
        }
    }
}
