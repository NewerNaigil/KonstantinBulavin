package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorSubTest {

    private final Calculator calculator = new Calculator();

    @DataProvider()
    public static Object[][] parseIntNumbers() {
        return new Object[][]{
                {3, 2, 1},
                {7, 5, 2},
                {0, 5, -5},
                {-3, -7, 4}
        };
    }

    @DataProvider()
    public static Object[][] parseDoubleNumbers() {
        return new Object[][]{
                {3, 2.5, 0.5},
                {3.1, 2.2, 0.9},
                {7.8, -5.2, 13.0},
                {-3.4, -1.1, -2.3}
        };
    }

    @Test(dataProvider = "parseIntNumbers")
    public void testSubtractionIntNumbers(long a, long b, long expected) {
        long actual = calculator.sub(a, b);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "parseDoubleNumbers")
    public void testSubtractionDoubleNumbers(double a, double b, double expected) {
        double actual = calculator.sub(a, b);
        Assert.assertEquals(actual, expected, 0.1);
    }
}
