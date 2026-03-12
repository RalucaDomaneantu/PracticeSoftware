package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.LogUtility;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="email")
    private WebElement emailElement;

    @FindBy(id="password")
    private WebElement passwordElement;

    @FindBy(xpath = "//input[@type = 'submit']")
    private WebElement loginButton;

    public void loginProcess(String email, String password){
        emailElement.sendKeys(email);
        LogUtility.infoLog("THE USER FILLS EMAIL FIELD WITH A VALUE" + email + "VALUE");
        passwordElement.sendKeys(password);
        LogUtility.infoLog("THE USER FILLS PASSWORD FIELD WITH A VALUE" + password + "VALUE");
        loginButton.click();
        LogUtility.infoLog("THE USER CLICKS ON LOGIN BUTTON");

    }
}
