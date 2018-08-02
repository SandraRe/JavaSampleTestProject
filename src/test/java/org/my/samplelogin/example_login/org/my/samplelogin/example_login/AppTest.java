package org.my.samplelogin.example_login.org.my.samplelogin.example_login;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	
	PositiveTests pTests;
	NegativeTests nTests;
    public AppTest( String testName )
    {
        super( testName );
        
 
    }
    

  
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

   
    public void testApp()
    {
        assertTrue( true );
    }
}
