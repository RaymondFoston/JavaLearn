package org.example;

import org.apache.log4j.Logger;

public class Log4jLogger {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Log4jLogger.class);
        logger.info("现在是log4j输出日志");
    }
}
