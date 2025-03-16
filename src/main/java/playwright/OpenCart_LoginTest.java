package playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;


	public class OpenCart_LoginTest {
	    public static void main(String[] args) {
	        // Initialize Playwright and launch the browser
	        try (Playwright playwright = Playwright.create()) {
	            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	            Page page = browser.newPage();
	            // Navigate to OpenCart login page
	            page.navigate("https://demo.opencart.com/index.php?route=account/login");

	            // Locate input fields and enter login details
	            page.locator("#input-email").type("johnny@gmail.com"); // Replace with a valid email
	            page.locator("#input-password").fill("Password123"); // Replace with a valid password

	            // Click on the Login button
	            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
	            
	            page.waitForTimeout(3000);
	            // Wait for navigation and check if login was successful
	            if (page.url().contains("/en-gb?route=account/")) {
	                System.out.println("✅ Login Successful!");
	            } else {
	                // Check for error message if login fails
	                String errorMessage = page.locator(".alert-danger").textContent();
	                System.out.println("❌ Login Failed! Error: " + errorMessage);
	            }

	            // Close the browser
	            browser.close();
	        }
	    }
	}
