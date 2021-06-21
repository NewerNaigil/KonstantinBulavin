package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorMultTest {

    private final Calculator calculator = new Calculator();

    @DataProvider()
    public static Object[][] parseIntNumbers() {
        return new Object[][] {
            {2, 2, 4},
            {3, 2, 6},
            {0, 5, 0},
            {-3, -7, 21}
        };
    }

    @DataProvider()
    public static Object[][] parseDoubleNumbers() {
        return new Object[][] {
            {2.5, 2.5, 6.25},
            {3.1, 2.2, 6.82},
            {7.8, -5.2, -40.56},
            {-3.4, -1.1, 3.74}
        };
    }

    @Test(groups = {Tags.MULTIPLY_AND_DIVIDE}, dataProvider = "parseIntNumbers")
    public void testMultiplicationIntNumbers(long a, long b, long expected) {
        long actual = calculator.mult(a, b);
        Assert.assertEquals(actual, expected);
    }

    @Test(groups = {Tags.MULTIPLY_AND_DIVIDE}, dataProvider = "parseDoubleNumbers")
    public void testMultiplicationDoubleNumbers(double a, double b, double expected) {
        double actual = calculator.mult(a, b);
        Assert.assertEquals(actual, expected, 0.01);
    }
}
