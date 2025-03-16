package orangeHRM;



	import com.microsoft.playwright.*;

	public class OrangeHRMLogin {
	    public static void main(String[] args) {
	        try (Playwright playwright = Playwright.create()) {
	            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	            Page page = browser.newPage();

	            // Navigate to the OrangeHRM login page
	            page.navigate("https://opensource-demo.orangehrmlive.com/");

	            // Locators based on actual DOM elements
	            String usernameField = "input[name='username']";
	            String passwordField = "input[name='password']";
	            String loginButton = "button[type='submit']";
	            String dashboardElement = "h6:has-text('Dashboard')";

	            // Enter credentials
	            page.fill(usernameField, "Admin");
	            page.fill(passwordField, "admin123");

	            // Click login
	            page.click(loginButton);

	            // Wait for Dashboard to appear (validating successful login)
	            page.waitForSelector(dashboardElement);

	            // Print success message
	            if (page.isVisible(dashboardElement)) {
	                System.out.println("Login successful!");
	            } else {
	                System.out.println("Login failed!");
	            }

	            // Close browser
	            browser.close();
	        }
	    }
	}


