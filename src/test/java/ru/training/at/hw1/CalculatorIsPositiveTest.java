package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorIsPositiveTest {

    private final Calculator calculator = new Calculator();

    @DataProvider()
    public static Object[][] parseLongNumbers() {
        return new Object[][] {
            {5, true},
            {4, true},
            {-7, false},
            {-3, false},
            {0, false}
        };
    }

    @Test(dataProvider = "parseLongNumbers")
    public void testIsPositiveNumber(long a, boolean expected) {
        boolean actual = calculator.isPositive(a);
        Assert.assertEquals(actual, expected);
    }
}
