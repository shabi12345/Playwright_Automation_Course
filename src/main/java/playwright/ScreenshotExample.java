package playwright;

import com.microsoft.playwright.*;
import java.nio.file.Paths;

public class ScreenshotExample {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            
            // Navigate to the given website
            String url = "https://demo.opencart.com";
            System.out.println("Navigating to: " + url);
            page.navigate(url);
            
            // Take a screenshot and save it
            String screenshotPath = "screenshots/opencart_homepage.png";
            System.out.println("Taking screenshot: " + screenshotPath);
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(screenshotPath)));
            
            // Close browser
            browser.close();
        }
    }
}
