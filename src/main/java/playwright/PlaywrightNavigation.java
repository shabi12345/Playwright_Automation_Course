package playwright;

import com.microsoft.playwright.*;
import java.util.Arrays;  // Import required for Arrays.asList
import java.util.List;

public class PlaywrightNavigation {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
        	 BrowserType.LaunchOptions options = new BrowserType.LaunchOptions()
                     .setChannel("chrome") // Use Google Chrome
                     .setHeadless(false); // Fix: Convert String[] to List<String>
            
             Browser browser = playwright.chromium().launch(options);
             Page page = browser.newPage();
            
            // Try with a different URL
            page.navigate("https://www.google.com");
            
            // Print current URL to check if navigation was successful
            System.out.println("Navigated URL: " + page.url());

            // Wait for some time to visually confirm the page loaded
            page.waitForTimeout(5000);

            browser.close();
        }
    }
}
