package com.demowebshop.tests;

import com.demowebshop.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class NavigationFlowTest {

    WebDriver driver;
    HomePage homePage;
    ProductPage productPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demowebshop.tricentis.com");

        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
    }

    @Test
    public void scrollToFooterTest() throws InterruptedException {
        homePage.searchForProduct("computer");

   
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        System.out.println("🧭 Page scrolled to bottom.");

        Thread.sleep(2000);

    
        WebElement footer = driver.findElement(By.cssSelector(".footer"));
        Assert.assertTrue(footer.isDisplayed(), " Footer is not visible!");
        System.out.println("Footer is visible. Test passed!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
