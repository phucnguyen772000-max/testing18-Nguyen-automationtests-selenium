package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage extends BasePage {
    private static final By MENU_ADMIN = By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']");
    private static final By USER_DROPDOWN = By.xpath("//span[contains(@class,'oxd-userdropdown-tab')]");
    private static final By LOGOUT_BTN = By.xpath("//a[@href='/web/index.php/auth/logout']");
// //span[test()='Admin']
    //a=> tim tat ca cac the troing a trong page
    //a=> chinh the a dang xet
    //.//span tin tat ca cac the sopan trobg a
    private static final By ADMIN_HEADER = By.xpath("//h6[text()='Admin']");
    public DashboardPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public boolean isElementPresnt() throws InterruptedException {
        WebElement menuAdmin = wait.until(ExpectedConditions.elementToBeClickable(MENU_ADMIN));
        boolean checklocators = true;
        if(!menuAdmin.isDisplayed())
        {
            checklocators = false;
            System.out.println("Khong tim thay locator menuadmin");
            return checklocators;
        }
        menuAdmin.click();

        WebElement adminHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(ADMIN_HEADER));
        if(!adminHeader.isDisplayed())
        {
            checklocators = false;
            System.out.println("Khong tim thay locator adminhheader");

        }
        Thread.sleep(2000);
        return checklocators;
    }
    public void logout()
    {
        WebElement userDropdown =wait.until(ExpectedConditions.visibilityOfElementLocated(USER_DROPDOWN));
        userDropdown.click();
        WebElement logoutBtn=wait.until(ExpectedConditions.elementToBeClickable(LOGOUT_BTN));
        logoutBtn.click();
    }
}