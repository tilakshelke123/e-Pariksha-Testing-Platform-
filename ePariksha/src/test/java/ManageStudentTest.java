


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class ManageStudentTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private ManageStudentPage studentPage;

    @BeforeMethod
    public void setUp() {
        BasePage.setupChromeDriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://ccst-testvm.pune.cdac.in:8080/epAdmin/index.jsp");
        loginPage = new LoginPage(driver);
        studentPage = new ManageStudentPage(driver);
        
        loginPage.performLogin("1057", "cdac1234");
        
       //loginPage.navigateToModules();
    }

    @Test(priority = 3)
    public void testStudentUpload() {
        studentPage.uploadStudentFile("src/test/resources/test-data/Student_Login_Data.xls");
    }
 
    @AfterMethod
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
