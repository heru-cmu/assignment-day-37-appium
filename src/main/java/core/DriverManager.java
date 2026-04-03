package core;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.URL;

public class DriverManager {
    private static AndroidDriver driver;

    public static AndroidDriver getDriver() {
        if (driver == null) {
            try {
                UiAutomator2Options options = new UiAutomator2Options()
                        .setDeviceName("emulator-5554")
                        .setPlatformVersion("13")
                        .setApp(System.getProperty("user.dir") + "/apk/saucedemo.apk");

                driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
