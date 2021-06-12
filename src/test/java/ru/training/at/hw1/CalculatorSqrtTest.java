package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorSqrtTest {

    private final Calculator calculator = new Calculator();

    @DataProvider()
    public static Object[][] parseDoubleNumbers() {
        return new Object[][]{
                {2.0, 1.41},
                {3.1, 1.76},
                {7.8, 2.79},
                {-3.0, 1.73}
        };
    }

    @Test(dataProvider = "parseDoubleNumbers")
    public void testSqrtDoubleNumbers(double a, double expected) {
        double actual = calculator.sqrt(a);
        Assert.assertEquals(actual, expected, 0.01);
    }
}
