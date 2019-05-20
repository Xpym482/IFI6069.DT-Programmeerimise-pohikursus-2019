package unitests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import junit.framework.TestCase;

public class MathematicsTest extends TestCase{
    // Extending TestCase is ONLY necessary if you want to use setUp() and tearDown() functions.
    // All other functionality below works perfectly without it.
    public String someDatabaseConnection;

    @Override  // Overriding functions from TestCase class
    public void tearDown(){  // Launches after tests have finished.
        // Every time you open a connection, you should properly close it 
        // according to the documentations instructions.

        this.someDatabaseConnection = null;
    }

    @Override  // Will launch before the test session.
    public void setUp(){
        this.someDatabaseConnection = "Connecting to a database is a time expensive process so doing it for every single test function is not reccomended, instead do it once and reuse it through the tests.";
    }


    @BeforeClass  // Any function marked with BeforeClass launches, similary to setUp() at the start of the session.
    public static void logStartOfTestSession(){
        // However, they ARE FORCED to be static, which means you can not save any data inside the class
        // to pass around through the tests.
        System.out.println("Testing session has started");
    }


    @AfterClass 
    public static void logEndOfTestSession(){
        // Similar to setUp, Before and BeforeClass put for After.
        System.out.println("Testing has ended.");
    }


    @Before  // this marks that the function will be triggered before a test function.
    public void thisWillPringBeforeEveryTestFunction(){
        System.out.println("Before test");
    }


    @After  // Same as after, every function marked by this will be triggered after a test function.
    public void thisWillPrintAfterEveryTestFunction(){
        System.out.println("After test");
    }

    @Test  // All test functions have to be marked with this and end with an assertion.
    public void testIfOnePlusOneIsTwo(){
        Mathematics math = new Mathematics();
        assertTrue(math.sum(1,1) == 2);  // Assert a condition.
    }


    @Test
    public void testIfTwoMinusOneIsOne(){
        Mathematics math = new Mathematics();
        System.out.println(this.someDatabaseConnection);
        assertEquals(math.minus(2, 1), 1);  // Assert a certain value.
    }


    @Test(expected = ArithmeticException.class)  // Expect an error of type ArithmeticException to be triggered.
    public void testIfDivisionThrowsExceptionOnZeroDivision(){
        // This method will fail when TestCase is extended.
        Mathematics math = new Mathematics();
        double result = math.division(5, 0);
    }

    @Test
    public void testIfDivisionByZeroErrorIsCaughtByItsMessage(){
        try {
            Mathematics math = new Mathematics();
            double result = math.division(5, 0);
        } catch (ArithmeticException e) {
            assertEquals(e.getMessage(), "/ by zero");
        }
    }
}