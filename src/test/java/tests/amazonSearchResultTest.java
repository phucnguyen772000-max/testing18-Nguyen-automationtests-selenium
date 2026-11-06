package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.amazonSearchResultPage;

public class amazonSearchResultTest extends BaseTest {
    // amazon khong can login
    @Test(description = "Bai tap 3 - find locators trang ket qua tim kiem adidas")
    public void findLocators() throws InterruptedException
    {
        amazonSearchResultPage searchPage = new amazonSearchResultPage(driver, wait);
        searchPage.open();
        // neu amazon hien captcha thi giai tay roi test se chay tiep
        searchPage.search("adidas");
        Assert.assertTrue(searchPage.isElementPresent());
    }
}
