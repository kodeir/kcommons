package com.kodeir.kcommons.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOWorker {

    public static String readFromInput(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = br.readLine();
            return s;
        } catch (IOException e) {
            System.err.println("Invalid Format! " + e);
            return "";
        }
    }

}
