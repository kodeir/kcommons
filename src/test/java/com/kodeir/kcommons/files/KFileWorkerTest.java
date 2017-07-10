package com.kodeir.kcommons.files;

import org.junit.After;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class KFileWorkerTest {

    private String testDirectory01 = "." + File.separator + "testDir01" + File.separator;
    private String testDirectory02 = "." + File.separator + "testDir01" + File.separator;
    private String testDirectory03 = "." + File.separator + "testDir01" + File.separator;
    private String defaultLogDirectory = "."+ File.separator+"logs"+File.separator;

    @After
    public void clean() throws Exception{
        Files.deleteIfExists(Paths.get(testDirectory01));
        Files.deleteIfExists(Paths.get(testDirectory02));
        Files.deleteIfExists(Paths.get(testDirectory03));
        Files.deleteIfExists(Paths.get(defaultLogDirectory));
    }

    @Test
    public void checkExists() throws Exception {
        KFileWorker.createDir(testDirectory03);
        assertTrue(KFileWorker.checkExists(testDirectory03));
    }

    @Test
    public void checkExistsFalse() throws Exception {
        assertFalse(KFileWorker.checkExists(testDirectory01));
    }

    @Test
    public void createDir() throws Exception {
        assertTrue(KFileWorker.createDir(testDirectory01));
    }

    @Test
    public void deleteDirRecursively() throws Exception {
        KFileWorker.createDir(testDirectory02);
        assertTrue(KFileWorker.deleteDirRecursively(testDirectory02));
    }

}