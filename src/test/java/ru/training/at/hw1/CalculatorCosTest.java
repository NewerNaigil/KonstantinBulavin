package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorCosTest {

    private final Calculator calculator = new Calculator();

    @DataProvider()
    public static Object[][] parseDoubleNumbers() {
        return new Object[][]{
                {5.3, 0.55},
                {4.1, -0.57},
                {7.8, 0.53},
                {-3.0, -0.98}
        };
    }

    @Test(dataProvider = "parseDoubleNumbers")
    public void testCosineDoubleNumbers(double a, double expected) {
        double actual = calculator.cos(a);
        Assert.assertEquals(actual, expected, 0.01);
    }
}
