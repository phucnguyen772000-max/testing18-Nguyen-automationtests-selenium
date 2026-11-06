package pages;
import io.qameta.allure.Allure;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
public class LoginPage extends BasePage
{
//        <input data-v-1f99f73c=""
//        class="oxd-input oxd-input--active"
//        name="username" placeholder="Username" autofocus="">/
    // xpayth: rule de tim locator trong trang web
//    //input[@name='username']
    private static final By INPUT_USERNAME= By.xpath("//input[@name='username']");
    private static  final By INPUT_PASSWORD= By.xpath("//input[@name='password']");
    private static final By LOGIN_BTN= By.xpath("//button[@type='submit']");
    public LoginPage(WebDriver driver, WebDriverWait wait)
    {
        super(driver,wait);
    }
    // step 1 truy cap vao page login
     public  void open()
     {
         Allure.step("open login page",()->{
             driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
             wait.until(ExpectedConditions.visibilityOfElementLocated(INPUT_USERNAME));
         });


     }
     //step 2: login
    // enterusername,enterpassword,clicklogin
    // 2 cach viet
    // c1: tach tung step thanh tung function
    // + uu diem de dang them log kiem tra, de sua,
    //c2: gom cac step thanh1 function
     public void login(String username, String password) throws InterruptedException {
        Allure.step("Enter username:"+ username,()->{
            WebElement usernameInput = driver.findElement(INPUT_USERNAME);
            usernameInput.sendKeys(username);
        });

         Thread.sleep(2000);
         Allure.step("Enter password",()->{
             WebElement passwordInput = driver.findElement(INPUT_PASSWORD);
             passwordInput.sendKeys(password);
         });


         Thread.sleep(2000);
         Allure.step("click login button",()->{
             WebElement loginBtn= driver.findElement(LOGIN_BTN);
             loginBtn.click();
         });

     }
}
