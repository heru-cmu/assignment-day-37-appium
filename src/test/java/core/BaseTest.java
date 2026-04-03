package core;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    @BeforeClass
    public void setUp() {
        DriverManager.getDriver();
    }

    @AfterClass
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
