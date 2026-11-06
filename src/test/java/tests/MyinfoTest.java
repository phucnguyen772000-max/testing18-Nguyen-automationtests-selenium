package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MyinfoPage;

public class MyinfoTest extends BaseTest {
    @BeforeMethod
    public void preCondition() throws InterruptedException
    {
        loginAsAdmin();
    }

    @Test(description = "upload avatar")
    public void uploadAvatar() throws InterruptedException
    {
        MyinfoPage myInfoPage = new MyinfoPage(driver, wait);
        myInfoPage.open();
        myInfoPage.uploadAvatar("logo.png");
        Assert.assertTrue(myInfoPage.isSuccessUpload());
    }
}