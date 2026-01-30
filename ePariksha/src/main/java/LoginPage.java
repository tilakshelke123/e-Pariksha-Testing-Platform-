

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    
   
    @FindBy(xpath = "//input[@name=\"txtUserId\"]") 
    private WebElement useridField;
    
    @FindBy(xpath = "//input[@name=\"txtPassword\"]") 
    private WebElement passwordField;
    
    @FindBy(xpath = "//img[@id=\"Image6\"]")
    private WebElement loginButton;
    
    @FindBy(xpath = "//h4[text()='Welcome Examiner']") 
    private WebElement successMessage;
    
    @FindBy(xpath = "//a[contains(text(),'Modules') or contains(text(),'module')]")
    private WebElement modulesLink;
    
    
   

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void performLogin(String userid, String password) {
        System.out.println("---Login Test----");
        enterText(useridField, userid, "UserID Entered  Successfully ");
        enterText(passwordField, password, "Password Entered  Successfully");
        clickElement(loginButton, " Click on Login Button");
        verifyElementVisible(successMessage, "Login Message Display Sucessfully!!!");
        System.out.println("=====Login Successfully===");
    }

    public void navigateToModules() {
        clickElement(modulesLink, "Modules Menu");
    }
    
   
}
