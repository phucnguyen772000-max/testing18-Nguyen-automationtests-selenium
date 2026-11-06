package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Bai tap 3: Amazon tim kiem "adidas" (14 locator)
// san pham amazon doi lien tuc => bat theo vi tri san pham (1,2,3,4) khong bat theo ten
public class amazonSearchResultPage extends BasePage {
    // dung By.id khi the co id
    private static final By INPUT_SEARCH = By.id("twotabsearchtextbox");   // 4
    private static final By ICON_CART = By.id("nav-cart");                 // 5

    // san pham

    private static final By IMG_PRODUCT3 = By.xpath("(//div[@data-component-type='s-search-result'])[3]//img[@class='s-image']");   // 1
    private static final By PRICE_PRODUCT4 = By.xpath("(//div[@data-component-type='s-search-result'])[4]//span[@class='a-price']"); // 2
    private static final By PRICE_PRODUCT2 = By.xpath("(//div[@data-component-type='s-search-result'])[2]//span[@class='a-price']"); // 3
    private static final By MENU_TODAYS_DEALS = By.xpath("//a[contains(text(),\"Today's Deals\")]");                                // 6
    private static final By ADD_TO_CART_BTN_PRODUCT1 = By.xpath("(//div[@data-component-type='s-search-result'])[1]//button[normalize-space()='Add to cart']"); // 7
    private static final By NAME_PRODUCT2 = By.xpath("(//div[@data-component-type='s-search-result'])[2]//h2");                     // 8
    private static final By BOUGHT_PRODUCT1 = By.xpath("(//div[@data-component-type='s-search-result']//span[contains(text(),'bought in past month')])[1]"); // 9
    private static final By BRAND_PRODUCT1 = By.xpath("(//div[@data-component-type='s-search-result'])[1]//h2[1]");                 // 10
    private static final By SECTION_RESULTS = By.xpath("//h2[normalize-space()='Results']");                                        // 11
    private static final By CHECKBOX_MEN = By.xpath("//div[@id='s-refinements']//span[text()='Men']");                              // 12
    private static final By TEXT_RESULT_COUNT = By.xpath("//span[contains(text(),'results for')]");                                 // 13
    private static final By SEE_MORE_LINK = By.xpath("(//div[@id='s-refinements']//span[text()='See more'])[1]");                  // 14

    public amazonSearchResultPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    // step 1: truy cap amazon va tim kiem
    public void open() {
        driver.get("https://www.amazon.com/");
    }

    public void search(String keyword) throws InterruptedException {
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(INPUT_SEARCH));
        searchInput.sendKeys(keyword);
        Thread.sleep(1000);
        // Keys.ENTER = nhan phim enter
        searchInput.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(TEXT_RESULT_COUNT));
    }

    private boolean checkLocator(By locator, String name) {
        try {

            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return element != null;
        } catch (Exception e) {
            System.out.println("Khong tim thay locator " + name);
            return false;
        }
    }

    // step 2: kiem tra tat ca locator
    public boolean isElementPresent() {
        boolean checklocators = true;
        if (!checkLocator(IMG_PRODUCT3, "imgProduct3")) checklocators = false;
        if (!checkLocator(PRICE_PRODUCT4, "priceProduct4")) checklocators = false;
        if (!checkLocator(PRICE_PRODUCT2, "priceProduct2")) checklocators = false;
        if (!checkLocator(INPUT_SEARCH, "inputSearch")) checklocators = false;
        if (!checkLocator(ICON_CART, "iconCart")) checklocators = false;
        if (!checkLocator(MENU_TODAYS_DEALS, "menuTodaysDeals")) checklocators = false;
        if (!checkLocator(ADD_TO_CART_BTN_PRODUCT1, "addToCartBtnProduct1")) checklocators = false;
        if (!checkLocator(NAME_PRODUCT2, "nameProduct2")) checklocators = false;
        if (!checkLocator(BOUGHT_PRODUCT1, "boughtProduct1")) checklocators = false;
        if (!checkLocator(BRAND_PRODUCT1, "brandProduct1")) checklocators = false;
        if (!checkLocator(SECTION_RESULTS, "sectionResults")) checklocators = false;
        if (!checkLocator(CHECKBOX_MEN, "checkboxMen")) checklocators = false;
        if (!checkLocator(TEXT_RESULT_COUNT, "textResultCount")) checklocators = false;
        if (!checkLocator(SEE_MORE_LINK, "seeMoreLink")) checklocators = false;
        return checklocators;
    }
}
