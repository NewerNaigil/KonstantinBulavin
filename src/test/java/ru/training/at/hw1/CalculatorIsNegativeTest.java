package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorIsNegativeTest {

    private final Calculator calculator = new Calculator();

    @DataProvider()
    public static Object[][] parseLongNumbers() {
        return new Object[][]{
                {5, false},
                {4, false},
                {-7, true},
                {-3, true},
                {0, false}
        };
    }

    @Test(dataProvider = "parseLongNumbers")
    public void testIsPositiveNumber(long a, boolean expected) {
        boolean actual = calculator.isNegative(a);
        Assert.assertEquals(actual, expected);
    }
}
