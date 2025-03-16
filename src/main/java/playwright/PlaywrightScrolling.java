package playwright;

import com.microsoft.playwright.*;

public class PlaywrightScrolling {
    public static void main(String[] args) {
        // Launch Playwright
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();

            // Navigate to a webpage
            page.navigate("https://example.com");

            // 1. Scroll to a specific element
            Locator element = page.locator("CSS_SELECTOR_HERE"); // Replace with the actual CSS selector
            element.scrollIntoViewIfNeeded(); // Scrolls the element into view
            System.out.println("Scrolled to the element successfully.");

            // 2. Scroll down by a specific amount (e.g., 500 pixels)
            page.evaluate("window.scrollBy(0, 500);");
            System.out.println("Scrolled down by 500 pixels.");

            // 3. Scroll to the bottom of the page
            page.evaluate("window.scrollTo(0, document.body.scrollHeight);");
            System.out.println("Scrolled to the bottom of the page.");

            // Wait a few seconds to observe the scrolling
            page.waitForTimeout(3000);

            // Close the browser
            browser.close();
        }
    }
}
