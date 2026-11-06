package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.DashboardPage;
import pages.LoginPage;

public class DashboardTest extends BaseTest {
    @BeforeMethod
    public void preCondition() throws InterruptedException
    {
        loginAsAdmin();
    }
    // static final Logger log = LoggerFactory.getLogger(DashboardTest.class);

    @Test(description = "find locators")
    public void findLocators() throws InterruptedException
    {
        //LoginPage loginPage = new LoginPage(driver,wait);
        //loginPage.open();
        //loginPage.login("admin", "admin123");

        //Thread.sleep(10000);
        //wait.until(ExpectedConditions.urlContains("dashboard"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']")));
        DashboardPage dashboardPage = new DashboardPage(driver,wait);
        Assert.assertTrue(dashboardPage.isElementPresnt());
    }
    @Test(description = "Logout")
    public void logout()
    {
        DashboardPage dashboardPage = new DashboardPage(driver,wait);
        dashboardPage.logout();
        Assert.assertTrue(driver.getCurrentUrl().contains(("login")));
    }
}
