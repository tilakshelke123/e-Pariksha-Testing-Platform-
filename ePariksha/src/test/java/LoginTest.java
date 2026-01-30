

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        BasePage.setupChromeDriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://ccst-testvm.pune.cdac.in:8080/epAdmin/index.jsp");
        loginPage = new LoginPage(driver);
    }

    @Test(priority = 1)
    public void testValidLogin() {
        loginPage.performLogin("1057", "cdac1234");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
