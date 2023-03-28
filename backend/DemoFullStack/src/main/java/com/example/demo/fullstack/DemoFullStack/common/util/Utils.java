package com.example.demo.fullstack.DemoFullStack.common.util;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Utils {

    static public String stackTraceToString(Throwable ex){
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        return sw.toString();
    }
}
