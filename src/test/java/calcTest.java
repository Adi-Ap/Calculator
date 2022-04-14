import calc.calc;
import org.testng.annotations.Test;
import static org.junit.Assert.*;

public class calcTest {
    private static final double DELTA = 1e-15;
    calc cal = new calc();

    @Test
    public void squareRootTest(){
        assertEquals("Square Root of number for True Positive", 10.0, cal.squareRoot(100), DELTA);
        assertEquals("Square Root of number for True Positive", Double.NaN, cal.squareRoot(-10), DELTA);
        assertNotEquals("Square Root of number for False Positive", 4.0, cal.squareRoot(21), DELTA);
        assertNotEquals("Square Root of number for False Positive", 5.0, cal.squareRoot(16), DELTA);
    }

    @Test
    public void factorialTest(){
        assertEquals("Factorial of number for True positive", 120.0,cal.fact(5), DELTA);
        assertEquals("Factorial of number for True positive", Double.NaN,cal.fact(-1), DELTA);
        assertNotEquals("Factorial of number for False positive", 8.0,cal.fact(3), DELTA);
        assertNotEquals("Factorial of number for False positive", 60.0,cal.fact(5), DELTA);
    }



    @Test
    public void logTest(){
        assertEquals("Factorial of number for True positive", 1.3862943611198906,cal.naturalLog(4), DELTA);
        assertEquals("Factorial of number for True positive", Double.NaN, cal.naturalLog(0), DELTA);
        assertNotEquals("Factorial of number for False positive", 2.833213344056216,cal.naturalLog(14), DELTA);
        assertNotEquals("Factorial of number for False positive", 1.791759469228055,cal.naturalLog(9), DELTA);
    }


    @Test
    public void powerTest(){
        assertEquals("Factorial of number for True positive", 4.0,cal.power(2, 2), DELTA);
        assertEquals("Factorial of number for True positive", 27.0,cal.power(3,3), DELTA);
        assertNotEquals("Factorial of number for False positive", 5.0,cal.power(3,3), DELTA);
    }
}
