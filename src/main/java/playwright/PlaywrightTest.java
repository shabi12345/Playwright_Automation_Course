package playwright;

import com.microsoft.playwright.*;

public class PlaywrightTest {
    public static void main(String[] args) {
    	   try (Playwright playwright = Playwright.create()) {
               Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
               BrowserContext context = browser.newContext();
               Page page = context.newPage();
               page.navigate("https://yahoo.com");  // Replace with your URL
               System.out.println("Page Title: " + page.title());
               browser.close();
           }
       
    }
}
