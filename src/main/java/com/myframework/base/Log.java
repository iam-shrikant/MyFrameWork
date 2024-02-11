package com.myframework.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Log {
    private static Logger log = LogManager.getLogger(Log.class);

    private Log(){

    }

    public static void fatal(String message){
        log.fatal(message);
    }

    public static void error(String message){
        log.error(message);
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
