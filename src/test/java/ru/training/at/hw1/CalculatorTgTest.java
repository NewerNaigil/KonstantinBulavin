package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorTgTest {

    private final Calculator calculator = new Calculator();

    @DataProvider()
    public static Object[][] parseDoubleNumbers() {
        return new Object[][] {
            {6.3, 0.01},
            {3.1, -0.04},
            {7.8, 18.5},
            {-3.0, 0.14}
        };
    }

    @Test(dataProvider = "parseDoubleNumbers")
    public void testTangentDoubleNumbers(double a, double expected) {
        double actual = calculator.tg(a);
        Assert.assertEquals(actual, expected, 0.01);
    }
}
