package ru.training.at.hw9.tests;

import org.testng.annotations.BeforeClass;
import ru.training.at.hw9.ConfigFileReader;

public class AbstractTest {

    ConfigFileReader configFileReader;

    @BeforeClass
    public void prepareTestData() {
        configFileReader = new ConfigFileReader();
    }

}
