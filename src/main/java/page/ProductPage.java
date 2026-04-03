package page;

import core.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class ProductPage extends BasePage {
    // Locator produk di halaman utama
    private By productItem = AppiumBy.androidUIAutomator(
            "new UiSelector().resourceId(\"com.saucelabs.mydemoapp.android:id/productIV\").instance(0)"
    );

    // Locator halaman detail produk
    private By productDetail = AppiumBy.accessibilityId("Displays selected product");

    // Locator tombol Add to Cart
    private By addToCartButton = AppiumBy.accessibilityId("Tap to add product to cart");

    // Locator icon Cart
    private By cartIcon = By.id("com.saucelabs.mydemoapp.android:id/cartIV");

    // Locator halaman checkout
    private By checkoutConfirm = AppiumBy.accessibilityId("Confirms products for checkout");

    public ProductPage(AndroidDriver driver) {
        super(driver);
    }

    public void selectProduct() {
        click(productItem);
    }

    public void addProductToCart() {
        click(addToCartButton);
    }

    public void openCart() {
        click(cartIcon);
    }

    public String getCheckoutConfirmText() {
        return getText(checkoutConfirm);
    }
}
