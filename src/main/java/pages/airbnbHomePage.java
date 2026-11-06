package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Bai tap 2: CyberSoftbnb trang chu
public class airbnbHomePage extends BasePage {
    private static final By LOGO = By.xpath("//a[@href='/']/img[@alt='Cyber Logo']");                       // 1
    private static final By MENU_HOME = By.xpath("//a[text()='Home']");                                       // 2
    private static final By MENU_ABOUT = By.xpath("//a[text()='About']");                                     // 3
    private static final By ICON_USER = By.xpath("//img[contains(@src,'6596121.png')]/parent::button");     // 4
    private static final By SELECT_LOCATION = By.xpath("//p[text()='Bạn sắp đi đâu?']/parent::div");        // 5
    private static final By SELECT_DATE = By.xpath("//p[text()='Bạn sắp đi đâu?']/parent::div/following-sibling::div[2]/p"); // 6
    private static final By SEARCH_BTN = By.xpath("//span[@aria-label='search']/parent::div");              // 7
    private static final By GUEST_PLUS_BTN = By.xpath("//button[div[text()='+']]");                          // 8
    private static final By GUEST_MINUS_BTN = By.xpath("//button[div[text()='-']]");                         // 9
    private static final By CARD_HO_CHI_MINH = By.xpath("//h2[text()='Hồ Chí Minh']/ancestor::div[contains(@class,'gap-3')]"); // 10
    private static final By TITLE_CAN_THO = By.xpath("//h2[text()='Cần Thơ']");                                // 11
    private static final By FILTER_LOAI_NOI_O_BTN = By.xpath("//button[text()='Loại nơi ở']");                // 12
    private static final By FILTER_GIA_BTN = By.xpath("//button[text()='Giá']");                              // 13
    private static final By TEXT_NHA_TRANG_DRIVE = By.xpath("//h2[text()='Nha Trang']/following-sibling::p[contains(text(),'6.5')]"); // 14
    private static final By GUEST_BOX = By.xpath("//p[text()='Thêm khách']");

    public airbnbHomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    // step 1: truy cap trang chu
    public void open() {
        driver.get("https://demo5.cybersoft.edu.vn/");
    }

    private boolean checkLocator(By locator, String name) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.isDisplayed();
        } catch (Exception e) {
            System.out.println("Khong tim thay locator " + name);
            return false;
        }
    }

    // step 2: kiem tra tat ca locator
    public boolean isElementPresent() throws InterruptedException {
        boolean checklocators = true;
        if (!checkLocator(LOGO, "logo")) checklocators = false;
        if (!checkLocator(MENU_HOME, "menuHome")) checklocators = false;
        if (!checkLocator(MENU_ABOUT, "menuAbout")) checklocators = false;
        if (!checkLocator(ICON_USER, "iconUser")) checklocators = false;
        if (!checkLocator(SELECT_LOCATION, "selectLocation")) checklocators = false;
        if (!checkLocator(SELECT_DATE, "selectDate")) checklocators = false;
        if (!checkLocator(SEARCH_BTN, "searchBtn")) checklocators = false;
        if (!checkLocator(CARD_HO_CHI_MINH, "cardHoChiMinh")) checklocators = false;
        if (!checkLocator(TITLE_CAN_THO, "titleCanTho")) checklocators = false;
        if (!checkLocator(FILTER_LOAI_NOI_O_BTN, "filterLoaiNoiOBtn")) checklocators = false;
        if (!checkLocator(FILTER_GIA_BTN, "filterGiaBtn")) checklocators = false;
        if (!checkLocator(TEXT_NHA_TRANG_DRIVE, "textNhaTrangDrive")) checklocators = false;

        // click mo popup them khach truoc khi tim nut +/-
        WebElement guestBox = wait.until(ExpectedConditions.elementToBeClickable(GUEST_BOX));
        guestBox.click();
        Thread.sleep(1000);
        if (!checkLocator(GUEST_PLUS_BTN, "guestPlusBtn")) checklocators = false;
        if (!checkLocator(GUEST_MINUS_BTN, "guestMinusBtn")) checklocators = false;
        return checklocators;
    }
}
