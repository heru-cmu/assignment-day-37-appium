package tests;

import core.BaseTest;
import core.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.LoginPage;

public class LoginTest extends BaseTest {
    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());

        System.out.println("[INFO] Open burger menu");
        loginPage.openLoginMenu();

        System.out.println("[INFO] Input credentials");
        loginPage.login("bod@example.com", "10203040");

        System.out.println("[INFO] Assertion halaman utama");
        String title = loginPage.getHomeTitle();
        Assert.assertEquals(title, "Products", "Login gagal, title tidak sesuai!");
    }
}
