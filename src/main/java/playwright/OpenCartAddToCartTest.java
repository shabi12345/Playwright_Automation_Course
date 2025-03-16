package playwright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class OpenCartAddToCartTest {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();

            // Navigate to the Mac product page
            page.navigate("https://demo.opencart.com/index.php?route=account/login");

            // Locate input fields and enter login details
            page.locator("#input-email").fill("johnny@gmail.com"); // Replace with a valid email
            page.locator("#input-password").fill("Password123"); // Replace with a valid password
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();

            
            page.waitForTimeout(2000);
            // Click on the Login button
            page.navigate("https://demo.opencart.com/en-gb/catalog/desktops/mac");
            
            page.waitForTimeout(2000);
            
            page.evaluate("window.scrollBy(0, 500);");
            System.out.println("Scrolled down by 500 pixels.");

            page.waitForTimeout(2000);
            // Click on the Mac product
            page.locator("//*[@id=\"product-list\"]/div/div/div[2]/form/div/button[1]").click();

            page.waitForTimeout(2000);
            Locator wishlistButton = page.locator("//*[@id=\"product-list\"]/div/div/div[2]/form/div/button[2]']");
            wishlistButton.click(new Locator.ClickOptions().setForce(true));

            // WAIT & GET TEXT: Capture the success message
            page.waitForSelector(".alert-success");
            String successMessage = page.locator(".alert-success").textContent();
            System.out.println("✅ Wishlist Confirmation: " + successMessage);

            // Click on "Add to Cart" button
            page.locator("#button-cart").click();

            // WAIT & GET TEXT: Capture success message
            page.waitForSelector(".alert-success");
            String successMessage2 = page.locator(".alert-success").textContent();
            System.out.println("✅ Product Added Successfully: " + successMessage2);

            // Validate Cart Count (Optional)
            String cartText = page.locator("#cart-total").textContent();
            System.out.println("🛒 Cart Summary: " + cartText);

            // Close the browser
            browser.close();
        }
    }
}

