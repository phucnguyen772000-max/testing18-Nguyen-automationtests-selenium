package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.hrmAdminPage;

public class hrmAdminTest extends BaseTest {
    @BeforeMethod
    public void preCondition() throws InterruptedException
    {
        loginAsAdmin();
    }

    @Test(description = "Bai tap 1 - find locators trang admin")
    public void findLocators() throws InterruptedException
    {
        hrmAdminPage adminPage = new hrmAdminPage(driver, wait);
        adminPage.open();
        Assert.assertTrue(adminPage.isElementPresent());
    }
}
