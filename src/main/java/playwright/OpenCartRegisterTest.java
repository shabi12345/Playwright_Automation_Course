package playwright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class OpenCartRegisterTest {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();

            // Navigate to Registration Page
            page.navigate("https://demo.opencart.com/index.php?route=account/register");

            // Fill out Registration Form using different locators
            page.getByPlaceholder("First Name").fill("Shosh");
            page.getByLabel("Last Name").fill("tasnaseem");
            //page.locator("#input-firstname").fill("John");  // ID Locator
            //page.locator("[name='lastname']").fill("Doe");  // Name Locator
            page.locator("//input[@id='input-email']").fill("johnny22@gmail.com");  // XPath Locator
            //page.locator("input#input-telephone").fill("1234567890");  // CSS Locator

            // Using getByRole() for Password fields
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill("Password123");
            //page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password Confirm")).fill("Password123");

            
            // Click 'Yes' for Newsletter using different locator types
            //page.locator("input[value='1']").click();  // Attribute-based CS
            
           //page.getByPlaceholder("First Name");
          //  page.getByLabel("input-firstname");
            page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("newsletter").setChecked(true));
            //page.locator("//input[@name='newsletter' and @value='1']").click();  // XPath alternative

            // Agree to Privacy Policy using getByRole() & CSS
           page.locator("input[name='agree']").click();
           // page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("I have read and agree")).click();

            // Click Continue using different approaches
            //page.locator("button[type='submit']").click();  // CSS
           Thread.sleep(6000); 
           page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();  // Aria Role

      
            // Validate success using multiple locators
            if (page.locator(".alert-success").isVisible()) {
                System.out.println("✅ Registration Successful!");
            } else {
                System.out.println("❌ Registration Failed!");
            }

            page.locator("//*[@id=\"content\"]/div/a").click();
            
           System.out.println("❌ Registration Done!");
            // Close Browser
            browser.close();
        } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
