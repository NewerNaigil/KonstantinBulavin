package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorPowTest {

    private final Calculator calculator = new Calculator();

    @DataProvider()
    public static Object[][] parseDoubleNumbers() {
        return new Object[][] {
            {3.0, 2.5, 9.0},
            {4.1, 2.2, 16.81},
            {-7.0, 3.2, -343.0},
            {3.5, -1.1, 0.08}
        };
    }

    @Test(dataProvider = "parseDoubleNumbers")
    public void testExponentiationDoubleNumbers(double a, double b, double expected) {
        double actual = calculator.pow(a, b);
        Assert.assertEquals(actual, expected, 0.01);
    }
}
