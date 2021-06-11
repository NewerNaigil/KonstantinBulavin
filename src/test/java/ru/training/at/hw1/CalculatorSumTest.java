package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorSumTest {

    private final Calculator calculator = new Calculator();

    @DataProvider()
    public static Object[][] parseIntNumbers() {
        return new Object[][]{
                {2, 2, 4},
                {3, 2, 5},
                {0, 5, 5},
                {-3, -7, -10}
        };
    }

    @DataProvider()
    public static Object[][] parseDoubleNumbers() {
        return new Object[][]{
                {2.5, 2.5, 5.0},
                {3.1, 2.2, 5.3},
                {7.8, -5.2, 2.6},
                {-3.4, -1.1, -4.5}
        };
    }

    @Test(dataProvider = "parseIntNumbers")
    public void testAddingIntNumbers(long a, long b, long expected) {
        long actual = calculator.sum(a, b);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "parseDoubleNumbers")
    public void testAddingDoubleNumbers(double a, double b, double expected) {
        double actual = calculator.sum(a, b);
        Assert.assertEquals(actual, expected, 0.1);
    }
}
