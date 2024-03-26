package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Assert;

/**
 * Unit test for simple App.
 */
public class JunitTest3 extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public JunitTest3(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( JunitTest3.class );
    }

    public void setUp(){

    }


    /**
     * Rigorous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
        Assert.assertTrue(1==1);
        assertEquals(2.5,2.5);
    }


    public void testapp(){
        System.out.println(1);
    }
}
