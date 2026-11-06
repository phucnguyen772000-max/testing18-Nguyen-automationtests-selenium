package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class MyinfoPage extends BasePage {
    private static final By AVATAR_IMG = By.xpath("//img[@class='employee-image']");
    private static final By UPLOAD_BTN = By.xpath("//button[contains(@class,'employee-image-action')]");
    private static final By FILE_INPUT = By.xpath("//input[@type='file']");
    private static final By SAVE_BTN = By.xpath("//button[@type='submit']");
    // DA SUA: oxd-toaster_1 la khung rong, phai tim the toast thanh cong ben trong
    private static final By SUCCESS_TOAST = By.xpath("//div[contains(@class,'oxd-toast--success')]");

    public MyinfoPage(WebDriver driver, WebDriverWait wait)
    {
        super(driver, wait);
    }

    //de vao page myinfo => 2 cach
    //c1 truy cap vao page voi duong dan page
    //c2 click vao nut my info
    public void open()
    {
        By myInfoLocator = By.xpath("//span[text()='My Info']");
        WebElement myInfoMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(myInfoLocator));
        myInfoMenu.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AVATAR_IMG));
    }

    public void uploadAvatar(String imageName) throws InterruptedException
    {
        //sau khi click xong menu doi avatar hien ra
        WebElement avatarImg = wait.until(ExpectedConditions.elementToBeClickable(AVATAR_IMG));
        avatarImg.click();

        //WebElement uploadBtn = wait.until(ExpectedConditions.elementToBeClickable(UPLOAD_BTN));
       // uploadBtn.click();

        WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(FILE_INPUT));
        // LUU Y: vi inputFile Selenium khong the thao tac truc tiep de tim file hinh
        // sendKeys de truyen duong dan tuyet doi cua hinh can upload
        // TIPS: luu hinh vao trong project
        String filePath = new File("src/test/resources/images/" + imageName).getAbsolutePath();
        fileInput.sendKeys(filePath);
        Thread.sleep(2000);

        WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(SAVE_BTN));
        saveBtn.click();
    }

    public boolean isSuccessUpload()
    {
        WebElement successToast = wait.until(ExpectedConditions.visibilityOfElementLocated(SUCCESS_TOAST));
        System.out.println("Toast: " + successToast.getText());
        return successToast.isDisplayed();
    }
}