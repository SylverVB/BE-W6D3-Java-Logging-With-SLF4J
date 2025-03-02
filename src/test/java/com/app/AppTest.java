package com.app;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.LoggerFactory;

public class AppTest {

    private Logger logger;
    private ListAppender<ILoggingEvent> listAppender;

    @Before
    public void setUp() {
        // Get a Logback logger
        logger = (Logger) LoggerFactory.getLogger(App.class);

        // Create a ListAppender to capture log events
        listAppender = new ListAppender<>();
        listAppender.start();

        // Add the appender to the logger
        logger.addAppender(listAppender);
    }

    @Test
    public void testLoggingMessages() {
        // Execute the main method to trigger logs
        App.main(null);

        // Get the logged events
        var logsList = listAppender.list;

        // Check if specific log messages are present
        assertTrue(logsList.stream().anyMatch(event -> event.getMessage().contains("my debug log")));
        assertTrue(logsList.stream().anyMatch(event -> event.getMessage().contains("my info log")));
        assertTrue(logsList.stream().anyMatch(event -> event.getMessage().contains("Exception Occurred")));

        // Check the logging levels
        assertEquals(Level.DEBUG, logsList.get(0).getLevel());
        assertEquals(Level.INFO, logsList.get(1).getLevel());
        assertEquals(Level.WARN, logsList.get(2).getLevel());
        assertEquals(Level.ERROR, logsList.get(3).getLevel());
    }
}