// QuestionRepoTest.java  



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class QuestionRepoTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private QuestionRepoPage questionRepo;

    @BeforeMethod
    public void setUp() {
        BasePage.setupChromeDriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://ccst-testvm.pune.cdac.in:8080/epAdmin/index.jsp");
        loginPage = new LoginPage(driver);
        questionRepo = new QuestionRepoPage(driver);
        
        loginPage.performLogin("1057", "cdac1234");
        loginPage.navigateToModules();
    }

    @Test(priority = 2)
    public void testQuestionUploadAndDelete() throws InterruptedException {
        questionRepo.uploadQuestionZip("src/test/resources/test-data/Bulk_Question_Upload.zip");
        questionRepo.deleteAllQuestions();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
