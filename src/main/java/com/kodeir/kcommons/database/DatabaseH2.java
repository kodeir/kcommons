package com.kodeir.kcommons.database;

public interface DatabaseH2 {

    /**
     *
     * @param database [file:][<path>]<databaseName> , e.g.:
     *                ~/test
     *                ."+File.separator+"data"+File.separator+databaseName
     * @param user
     * @param password
     * @param exists
     * @param encryption AES | XTEA | FOG or "" for no encryption
     * @return
     */
    boolean setConnectionIfDbExist(String database, String user, String password, boolean exists, String encryption);

}
