

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.DiscoveryStrategy.Explicit;

import java.io.File;

public class QuestionRepoPage extends BasePage {
    
    @FindBy(xpath = "//img[@id=\"18812\"]")
    private WebElement questionLink;
    
    @FindBy(xpath = "//a[text()='Upload Questions']")
    private WebElement quesRepoLink;
    
    @FindBy(xpath = "//input[@id=\"txtUploadFile\"]") 
    private WebElement zipUploadField;
    
    @FindBy(xpath = "//input[@type='file']") 
    private WebElement fileInput;
    
    @FindBy(xpath = "//input[@name=\"btnUpload\"]")
    private WebElement uploadButton;
    
    @FindBy(xpath = "//input[@id=\"zipPassword\"]")
    private WebElement filePass;
    
    @FindBy(xpath = "//input[@id=\"passwordSubmitArea\"]")
    private WebElement subFile;
    
    @FindBy(xpath = "//input[@id=\"chkSelectAll\"]") 
    private WebElement selectAllCheckbox;
    
    @FindBy(xpath = "//input[@id=\"rdDelete\"]") 
    private WebElement btnRadio;
    
    @FindBy(xpath = "//input[@id=\"btnDelete\"]")
    private WebElement deleteButton;
    
    @FindBy(xpath = "//label[@id=\"lblmessages\"]") 
    private WebElement uploadSuccessMsg;
    
    @FindBy(xpath = "//label[@id=\"lblmessages\"]") 
    private WebElement deleteSuccessMsg;

    public QuestionRepoPage(WebDriver driver) {
        super(driver);
    }

    public void uploadQuestionZip(String zipPath) throws InterruptedException {
        System.out.println("-----Upload  Questions------");
        clickElement(questionLink, "Question Menu");
        clickElement(quesRepoLink, "Question Repository");
        
        File zipFile = new File(zipPath);
        if (zipFile.exists()) {
            fileInput.sendKeys(zipFile.getAbsolutePath());
            clickElement(uploadButton, "Upload Button");
            filePass.sendKeys("Asdf@1234");
            clickElement(subFile, "Submit Zip File ");
//            wait.until(ExpectedConditions.visibilityOf(uploadSuccessMsg));
            Thread.sleep(5000);
            verifyElementVisible(uploadSuccessMsg, "Upload Success Message");
        } else {
            System.out.println("ZIP file not found:" + zipPath);
        }
    }

    public void deleteAllQuestions() throws InterruptedException {
        System.out.println("-------Upload Questions-------");
        clickElement(btnRadio, "Select Delete Radio Button");
        clickElement(selectAllCheckbox, "Select All the Checkboxes");
        clickElement(deleteButton, " Click on Delete Button");
        handleAlert();
        Thread.sleep(5000);
        verifyElementVisible(deleteSuccessMsg, "Delete  Message Display Suiccessfully !!!!");
    }
}
