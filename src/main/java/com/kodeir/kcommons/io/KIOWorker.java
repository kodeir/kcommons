package com.kodeir.kcommons.io;

import com.kodeir.kcommons.log.KLogger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KIOWorker {

    private static final Logger logger = Logger.getLogger(KLogger.class.getName());

    public static String readFromInput(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = br.readLine();
            return s;
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Invalid Format! " + e);
            return "";
        }
    }

    public static int parseInt(){
        try{
            int i = Integer.parseInt(readFromInput());
            return i;
        }catch(NumberFormatException e){
            logger.log(Level.SEVERE, "Invalid Format! " + e);
            return -1;
        }
    }

    public static String parseString(){
        try{
            String s = readFromInput();
            return s;
        }catch(NumberFormatException e){
            logger.log(Level.SEVERE, "Invalid Format! " + e);
            return "";
        }
    }

}
