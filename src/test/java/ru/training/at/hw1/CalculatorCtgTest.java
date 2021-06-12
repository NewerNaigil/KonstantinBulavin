package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorCtgTest {

    private final Calculator calculator = new Calculator();

    @DataProvider()
    public static Object[][] parseDoubleNumbers() {
        return new Object[][] {
            {6.3, 59.46},
            {3.1, -24.02},
            {7.8, 0.05},
            {-3.0, 7.01}
        };
    }

    @Test(dataProvider = "parseDoubleNumbers")
    public void testCotangentDoubleNumbers(double a, double expected) {
        double actual = calculator.ctg(a);
        Assert.assertEquals(actual, expected, 0.01);
    }
}
