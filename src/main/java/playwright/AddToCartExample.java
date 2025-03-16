package playwright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;

import java.nio.file.Paths;

public class AddToCartExample {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            
            // Navigate to the product page
            String url = "https://demo.opencart.com/en-gb/catalog/component/monitor";
            System.out.println("Navigating to: " + url);
            page.navigate(url);
            
            // Wait for the page to load
            page.waitForLoadState(LoadState.DOMCONTENTLOADED);
            
            // Click on 'Apple Cinema 30" product
            page.locator("text=Apple Cinema 30\"").waitFor();
            page.click("text=Apple Cinema 30\"");
            
            // Wait before interacting with the elements
            page.waitForTimeout(1000);
            
            // Scroll and select radio button
            page.locator("input[name='option[218]'][value='4']").waitFor();
            page.evaluate("element => element.scrollIntoView({ behavior: 'smooth', block: 'center' })", 
                          page.locator("input[name='option[218]'][value='5']").elementHandle());
            page.locator("input[name='option[218]'][value='5']").click();
            
            // Scroll and check a checkbox
            page.waitForTimeout(500);
            
            page.locator("input[name='option[223][]'][value='10']").waitFor();
           
            
            page.evaluate("element => element.scrollIntoView({ behavior: 'smooth', block: 'center' })", 
                          page.locator("input[name='option[223][]'][value='10']").elementHandle());
            page.locator("input[name='option[223][]'][value='10']").click();
            

            
            // Scroll and fill text field
            page.waitForTimeout(500);
            page.locator("textarea[name='option[208]']").waitFor();
            page.fill("textarea[name='option[208]']", "This is a test input.");
            
            // Scroll and upload file
            page.waitForTimeout(500);
            page.locator("input[name='file']").waitFor();
            page.setInputFiles("input[name='file']", Paths.get("sample.txt"));
            
            // Scroll and select date
            page.waitForTimeout(500);
            page.locator("input[name='option[219]']").waitFor();
            page.fill("input[name='option[219]']", "2025-02-22");
            
            // Enter quantity
            page.waitForTimeout(500);
            page.fill("input[name='quantity']", "1");
            
            // Wait for 'Add to Cart' button and click it
            page.locator("button#button-cart").waitFor();
            page.click("button#button-cart");
            
            // Close browser
            page.waitForTimeout(2000);
            browser.close();
        }
    }
}
