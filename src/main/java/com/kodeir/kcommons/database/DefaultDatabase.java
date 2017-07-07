package com.kodeir.kcommons.database;

import com.kodeir.kcommons.log.KLogger;

import java.sql.ResultSet;
import java.util.logging.Logger;

public class DefaultDatabase implements Database{

    private static final Logger logger = new KLogger(DefaultDatabase.class.getName());


    @Override
    public boolean setConnection(String database, String user, String password) {
        return false;
    }

    @Override
    public boolean closeConnection() {
        return false;
    }

    @Override
    public boolean setStatement() {
        return false;
    }

    @Override
    public boolean closeStatement() {
        return false;
    }

    @Override
    public boolean runExecuteUpdateQuery(String sql) {
        return false;
    }

    @Override
    public boolean runExecute(String sql) {
        return false;
    }

    @Override
    public ResultSet runSelectQuery(String sql) {
        return null;
    }

    @Override
    public boolean connectionIsNull() {
        return false;
    }

    @Override
    public boolean statementIsNull() {
        return false;
    }

    @Override
    public boolean commit() {
        return false;
    }
}
