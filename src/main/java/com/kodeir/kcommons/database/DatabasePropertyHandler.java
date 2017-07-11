package com.kodeir.kcommons.database;

import java.io.IOException;
import java.util.Properties;

public class DatabasePropertyHandler {

    private static DatabasePropertyHandler instance = null;

    private Properties properties = null;

    private final String path = "/config/database.properties";

    public static DatabasePropertyHandler getInstance() {
        if (instance == null){
            instance = new DatabasePropertyHandler();
        }
        return instance;
    }

    private DatabasePropertyHandler() {
        properties = new Properties();
        try {
            properties.load(DatabasePropertyHandler.class.getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getValue(String propKey) {
        return properties.getProperty(propKey);
    }

}
