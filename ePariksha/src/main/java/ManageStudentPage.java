

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.io.File;

public class ManageStudentPage extends BasePage {
    
    @FindBy(xpath = "//a[text()='Manage Students']") 
    private WebElement manageStudentLink;
    
    @FindBy(xpath = "//a[text()='Student Data']")
    private WebElement studentDataLink;
    
    @FindBy(xpath = "//input[@name=\"txtUploadFile\"]")
    private WebElement fileUploadField;
    
    @FindBy(xpath = "//input[@name=\"btnSubmit\"]") 
    private WebElement uploadButton;
    
    @FindBy(xpath = "//label[text()='Student data saved to the Database successfully.']")
    private WebElement uploadSuccessMsg;
    
    @FindBy(xpath = "//table[contains(@id,'student') or contains(@class,'student')]") 
    private WebElement studentTable;

    public ManageStudentPage(WebDriver driver) {
        super(driver);
    }
 
    public void uploadStudentFile(String filePath) {
        System.out.println("----Upload List of Sttudents----");
        clickElement(manageStudentLink, " Click on Managed Student");
        clickElement(studentDataLink, "Student Data");
        
        File studentFile = new File(filePath);
        if (studentFile.exists()) {
            fileUploadField.sendKeys(studentFile.getAbsolutePath());
           clickElement(uploadButton, "Upload Students Button");
            verifyElementVisible(uploadSuccessMsg, "Student Upload Display Message Successfully");
           
        } else {
            System.out.println("Student file not found: " + filePath);
        }
    }
}
