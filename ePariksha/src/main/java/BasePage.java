
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    protected void clickElement(WebElement element, String elementName) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            System.out.println("✅ Clicked: " + elementName);
        } catch (Exception e) {
            Assert.fail("❌ Failed to click " + elementName + ": " + e.getMessage());
        }
    }

    protected void enterText(WebElement element, String text, String fieldName) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            element.clear();
            element.sendKeys(text);
            System.out.println("✅ Entered in " + fieldName + ": " + text);
        } catch (Exception e) {
            Assert.fail("❌ Failed to enter text in " + fieldName + ": " + e.getMessage());
        }
    }

    protected void verifyElementVisible(WebElement element, String elementName) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            Assert.assertTrue(element.isDisplayed(), elementName + " not visible");
            System.out.println("✅ Verified visible: " + elementName);
        } catch (Exception e) {
            Assert.fail("❌ " + elementName + " verification failed: " + e.getMessage());
        }
    }

    protected void verifyElementText(WebElement element, String expectedText, String elementName) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            String actualText = element.getText().trim();
            Assert.assertEquals(actualText, expectedText, elementName + " text mismatch");
            System.out.println("✅ Verified text: " + elementName + " = " + actualText);
        } catch (Exception e) {
            Assert.fail("❌ Text verification failed for " + elementName + ": " + e.getMessage());
        }
    }

    protected void handleAlert() {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
            System.out.println("✅ Alert handled successfully");
        } catch (Exception e) {
            System.out.println("⚠️ No alert present");
        }
    }

    public static void setupChromeDriver() {
        WebDriverManager.chromedriver().setup();
    }
}
