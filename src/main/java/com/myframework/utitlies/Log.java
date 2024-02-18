package com.myframework.utitlies;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Log {
    private static Logger log = LogManager.getLogger(Log.class);

    private Log(){
        //not allowing anyone to create object of Log class
    }

    public static void fatal(String message){
        log.fatal(message);
    }

    public static void error(String message, Exception e){
        //log.error(message);
        log.log(Level.ERROR,message,e);
    }

    public static void warn(String message){
        log.warn(message);
    }

    public static void info(String message){
        log.info(message);
    }

    public static void debug(String message){
        log.debug(message);
    }

    public static void trace(String message){
        log.trace(message);
    }
}
