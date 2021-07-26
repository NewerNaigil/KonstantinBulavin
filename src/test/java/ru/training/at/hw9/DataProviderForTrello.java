package ru.training.at.hw9;

import static ru.training.at.hw9.constants.TestData.CREATE_BOARD_NAME;
import static ru.training.at.hw9.constants.TestData.DEFAULT_BOARD_NAME;

import org.testng.annotations.DataProvider;

public class DataProviderForTrello {

    @DataProvider
    public Object[][] nameProvider() {
        return new Object[][] {
            {CREATE_BOARD_NAME},
            {DEFAULT_BOARD_NAME}
        };
    }
}
