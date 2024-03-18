package org.example;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class JavaUtilLoging {

    public static void main(String[] args) {
        JUL();
    }

    //java.util.logging
    public static void JUL() {
        Logger logger = Logger.getLogger("org.example.App");
        //关闭系统默认配置
        logger.setUseParentHandlers(false);
        ConsoleHandler consoleHandler = new ConsoleHandler();
        logger.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL);
        logger.addHandler(consoleHandler);
        logger.severe("十分严重的，极为恶劣的");
        logger.warning("警告");
        logger.info("消息");
        logger.config("配置");
        logger.fine("详细");
        logger.finer("较详细");
        logger.finest("最详细");
        Logger.getGlobal().info("Global");
    }

}