package HelloWorld;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class HelloAppium {
    // How to open App using JAVA CODE + APPIUM
    private AndroidDriver driver;

    @BeforeClass
    public void setUp() {
        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName("dc2e71d8")
                .setPlatformVersion("13")
                .setApp(System.getProperty("user.dir") + "/apk/saucedemo.apk");

        try {
            URL appiumUrl = new URL("http://127.0.0.1:4723");
            driver = new AndroidDriver(appiumUrl, options);
            System.out.println("Appium success run");
        } catch (MalformedURLException e) {
            e.getStackTrace();
        }
    }

    @Test
    public void testHelLoAppium() {
        assert driver.getSessionId() != null;
        System.out.println("Session successfully created!");
        driver.findElement(AppiumBy.accessibilityId("View menu")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"WebView\")")).click();

    }



    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Quit driver");
        }
    }
}