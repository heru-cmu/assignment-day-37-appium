package page;

import core.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private By burgerMenu = AppiumBy.accessibilityId("View menu");
    private By loginMenuItem = AppiumBy.accessibilityId("Login Menu Item");
    private By usernameField = By.id("com.saucelabs.mydemoapp.android:id/nameET");
    private By passwordField = By.id("com.saucelabs.mydemoapp.android:id/passwordET");
    private By loginButton = AppiumBy.accessibilityId("Tap to login with given credentials");
    private By homeTitle = AppiumBy.accessibilityId("title");

    public LoginPage(AndroidDriver driver) {
        super(driver);
    }

    public void openLoginMenu() {
        click(burgerMenu);
        click(loginMenuItem);
    }

    public void login(String user, String pass) {
        type(usernameField, user);
        type(passwordField, pass);
        click(loginButton);
    }

    public String getHomeTitle() {
        waitForVisible(homeTitle);
        return getText(homeTitle);
    }

}
