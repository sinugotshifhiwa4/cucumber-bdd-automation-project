package com.orangehrm.reusableComponents;

public class CustomExceptionHandler {

    public static void handleExceptions(String methodName, Exception e){

        System.err.println("An exception occurred on method " + methodName + ": " + e);
        e.printStackTrace();
    }
}
