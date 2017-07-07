package com.kodeir.kcommons.io;

public class IOParser {

    public static int parseInt(){
        try{
            int i = Integer.parseInt(IOWorker.readFromInput());
            return i;
        }catch(NumberFormatException e){
            System.err.println("Invalid Format! " + e);
            return -1;
        }
    }

    public static String parseString(){
        try{
            String s = IOWorker.readFromInput();
            return s;
        }catch(NumberFormatException e){
            System.err.println("Invalid Format! " + e);
            return "";
        }
    }

}
