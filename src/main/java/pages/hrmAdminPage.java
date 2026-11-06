package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Bai tap 1: OrangeHRM > Admin > System Users (21 locator)
public class hrmAdminPage extends BasePage {
    // ===== sidebar ben trai =====
    // <a class="oxd-main-menu-item" href="/web/index.php/admin/viewAdminModule">
    private static final By MENU_ADMIN = By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']");   // 1
    private static final By MENU_PIM = By.xpath("//a[@href='/web/index.php/pim/viewPimModule']");         // 2
    private static final By MENU_LEAVE = By.xpath("//a[@href='/web/index.php/leave/viewLeaveModule']");   // 3

    // ===== form tim kiem =====
    // tim label truoc roi di len the cha (ancestor) de tim input ben trong
    private static final By INPUT_USERNAME = By.xpath("//label[text()='Username']/parent::div/following-sibling::div//input");   // 4
    private static final By DROPDOWN_USER_ROLE = By.xpath("//label[text()='User Role']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-text-input')]"); // 5
    // option chi hien ra khi da click mo dropdown
    private static final By OPTION_ADMIN = By.xpath("//div[@role='listbox']//span[text()='Admin']");   // 6
    private static final By OPTION_ESS = By.xpath("//div[@role='listbox']//span[text()='ESS']");       // 7
    private static final By INPUT_EMPLOYEE_NAME = By.xpath("//label[text()='Employee Name']/parent::div/following-sibling::div//input"); // 8
    private static final By RESET_BTN = By.xpath("//button[normalize-space()='Reset']");     // 9
    private static final By SEARCH_BTN = By.xpath("//button[normalize-space()='Search']");   // 10

    // ===== menu top =====
    private static final By TAB_USER_MANAGEMENT = By.xpath("//span[normalize-space()='User Management']");   // 11

    // ===== dong thu 2 trong bang =====
    // (//xpath)[2] => lay phan tu thu 2 trong danh sach tim duoc
    private static final By CHECKBOX_ROW2 = By.xpath("(//div[@class='oxd-table-card'])[2]//div[contains(@class,'oxd-checkbox-wrapper')]");   // 12
    private static final By USER_ROLE_ROW2 = By.xpath("(//div[@class='oxd-table-card'])[2]//div[@role='cell'][3]");                           // 13
    private static final By DELETE_BTN_ROW2 = By.xpath("(//div[@class='oxd-table-card'])[2]//i[contains(@class,'bi-trash')]/parent::button");  // 14
    private static final By EDIT_BTN_ROW2 = By.xpath("(//div[@class='oxd-table-card'])[2]//i[contains(@class,'bi-pencil-fill')]/parent::button"); // 15

    // ===== header bang =====
    private static final By HEADER_USER_ROLE = By.xpath("//div[@role='columnheader'][contains(.,'User Role')]");          // 16
    private static final By HEADER_EMPLOYEE_NAME = By.xpath("//div[@role='columnheader'][contains(.,'Employee Name')]");  // 17

    // ===== khac =====
    private static final By BREADCRUMB = By.xpath("//span[contains(@class,'oxd-topbar-header-breadcrumb')]");                       // 18
    private static final By COLLAPSE_SIDEBAR_BTN = By.xpath("//button[contains(@class,'oxd-main-menu-button')]");                    // 19
    private static final By TOGGLE_FILTER_BTN = By.xpath("//div[contains(@class,'oxd-table-filter-header-options')]//button");      // 20
    private static final By ADD_BTN = By.xpath("//button[normalize-space()='Add']");                                                // 21

    public hrmAdminPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    // step 1: click menu admin de vao trang system users
    public void open() {
        WebElement menuAdmin = wait.until(ExpectedConditions.elementToBeClickable(MENU_ADMIN));
        menuAdmin.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(CHECKBOX_ROW2));
    }

    // ham phu: kiem tra 1 locator co hien thi khong, neu khong thi in ra ten locator
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
        if (!checkLocator(MENU_ADMIN, "menuAdmin")) checklocators = false;
        if (!checkLocator(MENU_PIM, "menuPim")) checklocators = false;
        if (!checkLocator(MENU_LEAVE, "menuLeave")) checklocators = false;
        if (!checkLocator(INPUT_USERNAME, "inputUsername")) checklocators = false;
        if (!checkLocator(DROPDOWN_USER_ROLE, "dropdownUserRole")) checklocators = false;
        if (!checkLocator(INPUT_EMPLOYEE_NAME, "inputEmployeeName")) checklocators = false;
        if (!checkLocator(RESET_BTN, "resetBtn")) checklocators = false;
        if (!checkLocator(SEARCH_BTN, "searchBtn")) checklocators = false;
        if (!checkLocator(TAB_USER_MANAGEMENT, "tabUserManagement")) checklocators = false;
        if (!checkLocator(CHECKBOX_ROW2, "checkboxRow2")) checklocators = false;
        if (!checkLocator(USER_ROLE_ROW2, "userRoleRow2")) checklocators = false;
        if (!checkLocator(DELETE_BTN_ROW2, "deleteBtnRow2")) checklocators = false;
        if (!checkLocator(EDIT_BTN_ROW2, "editBtnRow2")) checklocators = false;
        if (!checkLocator(HEADER_USER_ROLE, "headerUserRole")) checklocators = false;
        if (!checkLocator(HEADER_EMPLOYEE_NAME, "headerEmployeeName")) checklocators = false;
        if (!checkLocator(BREADCRUMB, "breadcrumb")) checklocators = false;
        if (!checkLocator(COLLAPSE_SIDEBAR_BTN, "collapseSidebarBtn")) checklocators = false;
        if (!checkLocator(TOGGLE_FILTER_BTN, "toggleFilterBtn")) checklocators = false;
        if (!checkLocator(ADD_BTN, "addBtn")) checklocators = false;

        // option admin, ess chi hien khi mo dropdown => click dropdown truoc
        WebElement dropdownUserRole = wait.until(ExpectedConditions.elementToBeClickable(DROPDOWN_USER_ROLE));
        dropdownUserRole.click();
        Thread.sleep(1000);
        if (!checkLocator(OPTION_ADMIN, "optionAdmin")) checklocators = false;
        if (!checkLocator(OPTION_ESS, "optionEss")) checklocators = false;
        return checklocators;
    }
}
