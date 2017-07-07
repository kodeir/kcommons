package com.kodeir.kcommons.database;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class KPropertyHandler {

    private static KPropertyHandler instance = null;

    private Properties properties = null;

    private String path = "."+ File.separator+"config"+ File.separator+"database.properties";

    public static KPropertyHandler getInstance() {
        if (instance == null){
            instance = new KPropertyHandler();
        }
        return instance;
    }

    private KPropertyHandler() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getValue(String propKey) {
        return properties.getProperty(propKey);
    }

}
