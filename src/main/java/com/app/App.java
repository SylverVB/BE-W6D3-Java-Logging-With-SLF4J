package com.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App 
{
    public static void main( String[] args )
    {
        // System.out.println( "Hello World!" );
        Logger logger = LoggerFactory.getLogger(App.class);

        /*
         * 5 logging level we should know aew
         * trace    <--- least severe
         * debug
         * info
         * warn
         * error    <--- most severe
         */
        logger.trace("my trace log");
        logger.debug("my debug log");
        logger.info("my info log");
        logger.warn("my warn log");
        logger.error("my error log");
        // logger.info("My first log");

        /* logging an exception */
        try{
            throw new Exception();
        }catch(Exception e){
            logger.error("Exception Occurred", e);
        }
    }
}