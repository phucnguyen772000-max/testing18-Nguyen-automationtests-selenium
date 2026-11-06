package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AirbnbLoginPage extends BasePage{
    private static final By LOGIN_BTN = By.xpath("(//button[text()='Đăng nhập'])[1]");
    private static final By AVATAR_IMG = By.xpath("//img[@class='h-10']");
    private static final By USERNAME_INPUT = By.id("email");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By LOGIN_BTN_FORM = By.xpath("//button[@type='submit' and text()='Đăng nhập']");
    private static final By SUCCESS_TOAST = By.xpath("//div[contains(@class,'ant-message-notice-content')]");

    public AirbnbLoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void open() {
        driver.get("https://demo5.cybersoft.edu.vn/");

//        vì truy cập vào page cần test nên cần có thời gian để các locator xuất hiện trên page đó
        wait.until(ExpectedConditions.visibilityOfElementLocated(AVATAR_IMG));
    }

    public void login(String username, String password) {
//        vì hàm open đã tìm AVATAR_IMG => chắc chắn sẽ có locator đó trên giao diện => findElement
        WebElement avatarImg = driver.findElement(AVATAR_IMG);
        avatarImg.click();

        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(LOGIN_BTN));
        loginBtn.click();
//
        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_INPUT));
        usernameInput.sendKeys(username);

        WebElement passwordInput = driver.findElement(PASSWORD_INPUT);
        passwordInput.sendKeys(password);

        WebElement loginBtnForm = driver.findElement(LOGIN_BTN_FORM);
        loginBtnForm.click();
    }

    public boolean isSuccessLogin() {
        try {
            WebElement successToast = wait.until(ExpectedConditions.visibilityOfElementLocated(SUCCESS_TOAST));
            System.out.println("Toast: " + successToast.getText());
            return successToast.isDisplayed();
        } catch (Exception e) {
            System.out.println("Khong tim thay toast dang nhap");
            return false;
        }
    }

}