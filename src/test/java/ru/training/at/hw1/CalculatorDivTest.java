package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorDivTest {

    private final Calculator calculator = new Calculator();

    @DataProvider()
    public static Object[][] parseIntNumbers() {
        return new Object[][] {
            {2, 2, 1},
            {6, 2, 3},
            {0, 5, 0},
            {-21, -7, 3}
        };
    }

    @DataProvider()
    public static Object[][] parseDoubleNumbers() {
        return new Object[][] {
            {2.5, 2.5, 1.0},
            {3.1, 2.2, 1.4},
            {7.8, -5.2, -1.5},
            {-3.4, -1.1, 3.09}
        };
    }

    @DataProvider()
    public static Object[][] parseDivByZeroIntNumbers() {
        return new Object[][] {
            {2, 0},
            {-7, 0},
            {0, 0}
        };
    }

    @DataProvider()
    public static Object[][] parseDivByZeroDoubleNumbers() {
        return new Object[][] {
            {2.5, 0},
            {-7.3, 0},
            {0, 0}
        };
    }

    @Test(groups = {Tags.MULTIPLY_AND_DIVIDE}, dataProvider = "parseIntNumbers")
    public void testDivisionIntNumbers(long a, long b, long expected) {
        long actual = calculator.div(a, b);
        Assert.assertEquals(actual, expected);
    }

    @Test(groups = {Tags.MULTIPLY_AND_DIVIDE}, dataProvider = "parseDoubleNumbers")
    public void testDivisionDoubleNumbers(double a, double b, double expected) {
        double actual = calculator.div(a, b);
        Assert.assertEquals(actual, expected, 0.01);
    }

    @Test(groups = {Tags.MULTIPLY_AND_DIVIDE},
          dataProvider = "parseDivByZeroIntNumbers",
          expectedExceptions = NumberFormatException.class)
    public void testDivisionByZeroIntNumbers(long a, long b) {
        calculator.div(a, b);
    }

    @Test(groups = {Tags.MULTIPLY_AND_DIVIDE},
          dataProvider = "parseDivByZeroDoubleNumbers",
          expectedExceptions = ArithmeticException.class)
    public void testDivisionByZeroDoubleNumbers(double a, double b) {
        calculator.div(a, b);
    }
}
