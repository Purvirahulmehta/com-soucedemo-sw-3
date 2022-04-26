package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @After
    public void teardown() {
        closeBrowser();
    }

    @Test
    public void userSholdLoginSuccessfullyWithValid() {
        //finding username element
        sendTextToElement(By.name("user-name"), "standard_user");
        //finding password element
        sendTextToElement(By.id("password"), "secret_sauce");
        //finding log in button element
        clickOnElement(By.id("login-button"));
        //finding element of Product tab
        String productTab1 = getTextFromElement(By.xpath("//span[contains(text(),'Products')]"));
        //expected message
        String expectedMessage = "PRODUCTS";
        // Validate actual and expected message
        Assert.assertEquals("Product page", productTab1, expectedMessage);

    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        sendTextToElement(By.name("user-name"), "standard_user");
        sendTextToElement(By.id("password"), "secret_sauce");
        clickOnElement(By.id("login-button"));
        //finding the element of a product
        List<WebElement> product = driver.findElements(By.className("inventory_item"));
        //finding the size of product
        int size = product.size();
        System.out.println(size);//it will print the size in console
        int expectedMessage = 6;
        // Validate actual and expected message
        Assert.assertEquals("Product is not in display", expectedMessage, size);

    }


}


