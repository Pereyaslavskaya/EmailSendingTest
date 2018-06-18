package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import helpers.UtilityMethods;


import static helpers.MainPageSelectors.*;

public class MainPage extends Page {

    @FindBy(how = How.ID, using = MAILBOX_LOGIN)
    private WebElement mailBoxLogin;

    @FindBy(how = How.ID, using = MAILBOX_DOMAIN)
    private WebElement mailBoxSelect;

    @FindBy(how = How.ID, using = MAILBOX_PASSWORD)
    private WebElement mailBoxPassword;

    @FindBy(how = How.ID, using = MAILBOX_SAVEAUTH)
    private WebElement mailBoxSaveAuth;

    @FindBy(how = How.ID, using = MAILBOX_SUBMIT)
    private WebElement mailBoxSubmit;

    @FindBy(how = How.ID, using = MAIL_LINK)
    private WebElement mailLink;

    @FindBy(how = How.ID, using = ENTRANCE_LINK)
    private WebElement entranceLink;

    @FindBy(how = How.ID, using = SIGNOUT_LINK)
    private WebElement signOutLink;

    @FindBy(how = How.ID,using =USER_IS_SIGNIN )
    private WebElement userIsSignin;

    private UtilityMethods signin=new UtilityMethods();

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public MainPage open(){
        super.open(URL);
        return new MainPage(driver);
    }


    public EmailPageMessages SignInInMailBox(String login,String domain, String password){
        signin.enterLogin(this.mailBoxLogin,login);
        signin.selectDomain(this.mailBoxSelect,domain);
        signin.enterPassword(this.mailBoxPassword,password);
        signin.submit(this.mailBoxSubmit);
        return new EmailPageMessages(driver);
    }

    public LoginPage enterToMailByMailLink(){
        this.mailLink.click();
        return  new LoginPage(driver);
    }

    public LoginPage enterToMailByEntranceLink()  {
        this.entranceLink.click();
        return  new LoginPage(driver);
    }

    public MainPage SignOutIfNecessary(){
        if (this.userIsSignin.isDisplayed())
          this.signOutLink.click();
        return new MainPage(driver);
    }
}
