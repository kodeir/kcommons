package com.kodeir.kcommons.database;

public interface DatabaseH2 {

    boolean setConnectionIfDbExist(String database, String user, String password);

}
