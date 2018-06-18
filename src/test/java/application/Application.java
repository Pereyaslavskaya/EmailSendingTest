package application;

import org.openqa.selenium.WebDriver;
import pages.*;

public class Application {

    private MainPage mainPage;
    private LoginPage loginPage;
    private EmailPageMessages emailPageMessages;
    private EmailPageSendMS emailPageSendMS;
    private EmailPageCompose emailPageCompose;


    public Application(WebDriver driver){
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        emailPageCompose = new EmailPageCompose(driver);
        emailPageMessages = new EmailPageMessages(driver);
        emailPageSendMS = new EmailPageSendMS(driver);
    }

    public EmailPageCompose getEmailPageCompose() {
        return this.emailPageCompose;
    }

    public EmailPageSendMS getEmailPageSendMS() {
        return this.emailPageSendMS;
    }

    public EmailPageMessages getEmailPageMessages() {
        return this.emailPageMessages;
    }

    public LoginPage getLoginPage() {
        return this.loginPage;
    }

    public MainPage getMainPage() {
        return this.mainPage;
    }
}
