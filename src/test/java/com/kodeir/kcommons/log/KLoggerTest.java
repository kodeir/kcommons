package com.kodeir.kcommons.log;

import com.kodeir.kcommons.files.KFileWorker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;

import static org.junit.Assert.*;

public class KLoggerTest {

    private static String testLogDirectory = "."+ File.separator+"testDir";
    private String testLogName = "testName";
    private String logFileEnding = ".0.log";

    @Before
    public void setUp() throws Exception {
        KFileWorker.createDir(testLogDirectory);
    }

    @After
    public void tearDown() throws Exception {
        KFileWorker.deleteDirRecursively(testLogDirectory);
    }

    @Test
    public void testConstructor_Name() throws Exception {
        KLogger logger = new KLogger(testLogName);
        logger.closeHandlers();
        assertTrue(Files.exists(Paths.get(testLogDirectory + testLogName + logFileEnding)));
    }

    @Test
    public void testConstructor_NameSizeCountPath() throws Exception {
        KLogger logger = new KLogger(testLogName, 10, (byte)1, testLogDirectory);
        logger.closeHandlers();
        assertTrue(Files.exists(Paths.get(testLogDirectory + testLogName + logFileEnding)));
    }

    @Test
    public void testConstructor_NameSizeCountPathLevels() throws Exception {
        KLogger logger = new KLogger(testLogName, 1000, (byte)2, testLogDirectory, Level.INFO, Level.FINE);
        logger.closeHandlers();
        assertTrue(Files.exists(Paths.get(testLogDirectory + testLogName + logFileEnding)));
    }

    @Test
    public void testConstructor_FalseCount() throws Exception {
        KLogger logger = new KLogger(testLogName, -1, (byte)-1, testLogDirectory);
        logger.closeHandlers();
        assertTrue(Files.exists(Paths.get(testLogDirectory + testLogName + logFileEnding)));
    }
}