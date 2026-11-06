package tests;

import com.google.gson.Gson;
import io.qameta.allure.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ConfigReader;

import java.io.InputStream;
import java.io.InputStreamReader;
// keyword trong agile/Scrum
// epic-> 1 task bụ; Authentication, authorization,user management
//1 epic sẽ có nhiều
@Epic("Authentication")
@Feature("login")
public class LoginTest extends BaseTest {
    record LoginData(String username, String password, boolean success) {}

    //@dataprovider: testng lay thongtin data chay test cho data
    //b1: viet funtion doc data.json
    @DataProvider(name = "loginData")
    public Object[][] loginDataProvider()
    {
        InputStreamReader reader = new InputStreamReader(
                LoginTest.class.getResourceAsStream("/login-data.json")
        );
        //Gson bien du lieu file dang json thanh dang object Logindata
        LoginData[] list = new Gson().fromJson(reader, LoginData[].class);    ;
       //data mau
        // (Admin admin123 true)
        //(admin fail_pass fail)
        //(fail_user fail_passs fail)
        Object[][] dataLogin = new Object[list.length][1];
        for (int i = 0; i < list.length; i++) {
            dataLogin[i][0] = list[i];
        }
        return dataLogin;
    }

    //b2: loaddata vao test case
    @Story("login with data")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test login voi nhieu bo data", dataProvider = "loginData")
    public void testLoginData(LoginData data) throws InterruptedException
    {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.open();
        loginPage.login(data.username(), data.password());

        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl().contains("dashboard"),data.success());
    }

    @Story("login success")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test login success")
    public void testLoginSuccess() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.open();
        loginPage.login(ConfigReader.get("username"),ConfigReader.get("password"));

        wait.until(ExpectedConditions.urlContains("dashboard"));
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);

        Assert.assertTrue(currentUrl.contains("dashboard"));
    }
}