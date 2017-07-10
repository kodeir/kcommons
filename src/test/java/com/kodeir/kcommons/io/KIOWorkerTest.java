package com.kodeir.kcommons.io;

import org.junit.AfterClass;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.Assert.*;

public class KIOWorkerTest {

    @AfterClass
    public static void tearDown() throws Exception {
        System.setIn(System.in);
    }

    @Test
    public void testReadFromInput() throws Exception {
        System.setIn(new ByteArrayInputStream("Test string".getBytes(StandardCharsets.US_ASCII)));
        assertEquals("Test string", KIOWorker.parseString());
    }

    @Test
    public void testParseInt() throws Exception {
        System.setIn(new ByteArrayInputStream("5".getBytes()));
        assertEquals(5, KIOWorker.parseInt());
    }

    @Test
    public void testParseString() throws Exception {
        System.setIn(new ByteArrayInputStream("Test string".getBytes(StandardCharsets.US_ASCII)));
        assertEquals("Test string", KIOWorker.parseString());
    }

}