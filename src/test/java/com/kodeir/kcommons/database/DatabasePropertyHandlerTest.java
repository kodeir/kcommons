package com.kodeir.kcommons.database;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DatabasePropertyHandlerTest {

    @Test
    public void getValue() throws Exception {
        assertEquals("test", DatabasePropertyHandler.getInstance().getValue("datasource.url"));
    }

}