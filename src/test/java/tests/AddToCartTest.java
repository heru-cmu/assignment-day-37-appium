package tests;

import core.BaseTest;
import core.DriverManager;
import page.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {
    @Test
    public void testAddProductToCart() {
        ProductPage productPage = new ProductPage(DriverManager.getDriver());

        System.out.println("[INFO] Klik produk di halaman utama");
        productPage.selectProduct();

        System.out.println("[INFO] Klik tombol Add to Cart");
        productPage.addProductToCart();

        System.out.println("[INFO] Buka cart");
        productPage.openCart();

        System.out.println("[INFO] Assertion checkout confirm");
        String confirmText = productPage.getCheckoutConfirmText();
        Assert.assertTrue(confirmText.contains("Checkout"),
                "Produk gagal masuk ke cart atau checkout tidak muncul!");
    }
}
