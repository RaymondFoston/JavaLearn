package org.example;

import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

//        System.setProperty("webdriver.chrome.driver", "D:/BrowserDriver/chromedriver.exe");


        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.baidu.com");

        System.out.println( "Hello World!" );
    }
}
