package playwright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.ElementHandle.SelectTextOptions;
import com.microsoft.playwright.options.ElementState;

public class OpenCartProductPageAutomation {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();

            // Navigate to the product page
            page.navigate("https://demo.opencart.com/en-gb/product/component/monitor/apple-cinema");

            // Select from the dropdown (Select 'Red' option)
            //page.locator("#input-option217").selectOption("4"); // 4 is the value for 'Red'

            // Click a checkbox (Check 'Checkbox 1')
            page.waitForTimeout(500);
            Locator radio = page.locator("input[name='option[223][]'][value='10']");
            ((ElementHandle) radio).waitForElementState(ElementState.VISIBLE);
            radio.check();
            // Select a radio button (Choose 'Radio 2')
            page.locator("input[name='option[21]'][value='7']").check(); // Selecting 'Radio 2'

            page.locator("#input-option217").selectOption("1");
            // Enter a date in the date picker
            		
            page.locator("#input-option219").fill("2025-12-25"); // Selecting 25th December 2025
            page.locator("input[name='option[218]'][value='7']").check(new Locator.CheckOptions().setForce(true));

            // Upload a file
           
         // Checking a checkbox (Checkbox 1)
            page.locator("input[name='option[223][]'][value='10']").check(); 
            // Selecting a radio button (Radio 2)
            page.locator("input[name='option[218]'][value='7']").check(); 
          
            
            Locator fileUpload = page.locator("input[type='file']"); 
            fileUpload.inputValue(); // Provide actual path
           
            // Click "Add to Cart" button
            page.locator("button#button-cart").click();

            // Validate success message
            String successMessage = page.locator(".alert-success").textContent();
            System.out.println("✅ Success Message: " + successMessage);
            // Close browser
            browser.close();
        }
    }
}
