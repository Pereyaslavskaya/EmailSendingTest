package pages;


import helpers.UtilityMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.PageFactory;


import static helpers.LoginPageSelectors.*;


public class LoginPage extends Page{

    @FindBy(how = How.XPATH, using = LOGIN_FIELD)
    private WebElement loginFild;

    @FindBy(how = How.XPATH, using =DOMAIN_SELECT)
    private WebElement domainSelect;

    @FindBy(how = How.XPATH, using = SELECT_OPTION)
    private WebElement selectOption;

    @FindBy(how = How.XPATH, using = PASSWORD_FIELD)
    private WebElement passwordField;

    @FindBy(how = How.XPATH, using = SAVEAUTH)
    private WebElement saveAuth;

    @FindBy(how = How.XPATH, using = SUBMIT_BUTTON)
    private WebElement submitButton;

    @FindBy(how = How.XPATH, using = FRAME)
    private WebElement frame;

    private UtilityMethods signin=new UtilityMethods();

    public LoginPage (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }


    public EmailPageMessages SigninByLink(String login, String password){
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
        signin.waitFullFrameLoading(driver, (long) 20);
        signin.enterLogin(loginFild,login);
        signin.setDomain(driver,this.domainSelect,this.selectOption);
        signin.enterPassword(this.passwordField,password);
        signin.submit(this.submitButton);
        driver.switchTo().parentFrame();
        return new EmailPageMessages(driver);
    }



}
