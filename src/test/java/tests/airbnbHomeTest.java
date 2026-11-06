package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.airbnbHomePage;

public class airbnbHomeTest extends BaseTest {
    // trang airbnb khong can login
    @Test(description = "Bai tap 2 - find locators trang chu airbnb")
    public void findLocators() throws InterruptedException
    {
        airbnbHomePage homePage = new airbnbHomePage(driver, wait);
        homePage.open();
        Assert.assertTrue(homePage.isElementPresent());
    }
}
