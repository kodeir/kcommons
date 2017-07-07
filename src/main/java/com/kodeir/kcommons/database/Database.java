package com.kodeir.kcommons.database;

import java.sql.ResultSet;

public interface Database {

    boolean setConnection(String database, String user, String password);

    boolean closeConnection();

    boolean setStatement();

    boolean closeStatement();

    boolean runExecuteUpdateQuery(String sql);

    boolean runExecute(String sql);

    ResultSet runSelectQuery(String sql);

    boolean connectionIsNull();

    boolean statementIsNull();

    boolean commit();

}
