package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AirbnbLoginPage;

public class AirbnbLoginTest extends BaseTest {
    @Test(description = "Dang nhap airbnb thanh cong")
    public void testLoginSuccess()
    {
        String username = System.getenv("AIRBNB_TEST_USERNAME");
        String password = System.getenv("AIRBNB_TEST_PASSWORD");
        Assert.assertNotNull(username, "Thieu bien moi truong AIRBNB_TEST_USERNAME");
        Assert.assertNotNull(password, "Thieu bien moi truong AIRBNB_TEST_PASSWORD");

        AirbnbLoginPage loginPage = new AirbnbLoginPage(driver, wait);
        loginPage.open();
        loginPage.login(username, password);
        Assert.assertTrue(loginPage.isSuccessLogin(), "Dang nhap that bai");
    }
}
