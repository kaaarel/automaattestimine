import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kaare_000 on 3.11.2015.
 */
public class CalculatorTest {
    private Calculator calculator;
    @Before
    public void initialize() {
        calculator = new Calculator();
    }
    @Test
    public void testPaySalary() throws Exception {
        assertEquals(0, calculator.regularSalary(1, 0));
        assertEquals(10, calculator.regularSalary(1, 1));
        assertEquals(15, calculator.regularSalary(2, 1));
        assertEquals(22, calculator.regularSalary(3, 1));
        assertEquals(360, calculator.regularSalary(1, 22));
        assertEquals(540, calculator.regularSalary(2, 22));
        assertEquals(1056, calculator.regularSalary(3, 22));
    }

    @Test
    public void testHeroBonus() throws Exception {
        assertEquals(0, calculator.heroBonus(1, 1));
        assertEquals(0, calculator.heroBonus(2, 2));
        assertEquals(0, calculator.heroBonus(3, 3));
        assertEquals(10, calculator.heroBonus(1, 21));
        assertEquals(20, calculator.heroBonus(2, 21));
        assertEquals(30, calculator.heroBonus(3, 21));
    }

    @Test
    public void testFinalPay() throws Exception {
        assertEquals(370, calculator.finalPay(1, 22));
        assertEquals(560, calculator.finalPay(2, 22));
        assertEquals(1086, calculator.finalPay(3, 22));
        assertEquals(0, calculator.finalPay(1, 0));
        assertEquals(10, calculator.finalPay(1, 1));
        assertEquals(15, calculator.finalPay(2, 1));
        assertEquals(22, calculator.finalPay(3, 1));
    }

    @Test(expected=IllegalArgumentException.class)
    public void wrongWorkerType() {
        calculator.finalPay(5, 5);
    }
}