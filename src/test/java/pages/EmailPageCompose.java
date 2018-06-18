package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import static helpers.EmailPageComposeSelectors.*;

public class EmailPageCompose extends Page {

    @FindBy(how = How.CSS, using = TO_WHOM )
    private WebElement toWhom;

    @FindBy(how = How.CSS, using = COMPOSE_FRAME)
    private WebElement frame;

    @FindBy(how = How.CSS, using = LETTER_BODY)
    private WebElement letterBody;

    @FindBy(how = How.XPATH, using = CONFERM_EMPTY)
    private WebElement confermEmpty;

    @FindBy(how = How.XPATH, using = SEND)
    private WebElement send;

    @FindBy(how = How.XPATH,using = SUBJECT)
    private WebElement subject;

    public EmailPageCompose(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void text(){
        String str="Test test test test test test test"+"\n"+
                "Test test test test test test test"+"\n"+"Test test test test test test test"+"\n"+
                "Test test test test test test test"+"\n"+"Test test test test test test test"+"\n"+
                "Test test test test test test test"+"\n"+"Test test test test test test test"+"\n"+
                "Test test test test test test test"+"\n"+"Test test test test test test test"+"\n"+
                "Test test test test test test test"+"\n"+"Test test test test test test test"+"\n"+
                "Test test test test test test test"+"\n";
        StringSelection selection=new StringSelection(str);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
    }


    public void setToWhom(String toWhom){
        this.toWhom.sendKeys(toWhom);
    }

    public void clearToWhom(){
        this.subject.click();
        this.toWhom.click();
        this.toWhom.clear();

    }


    public void setLetterBody(){
        text();
        driver.switchTo().frame(frame);
        this.letterBody.sendKeys(Keys.CONTROL+"v");
        driver.switchTo().parentFrame();
    }

    public EmailPageSendMS sendEmail(WebElement element){
        element.click();
        return new EmailPageSendMS(driver);
    }

    public void sendEmptyLetter(String toWhom){
        setToWhom(toWhom);
        sendEmail(this.send);
        sendEmail(this.confermEmpty);
    }

    public void sendLetter(String toWhom){
        setToWhom(toWhom);
        setLetterBody();
        sendEmail(this.send);
    }

    public void sendLetterInvalidAddress(String toWhom){
        setToWhom(toWhom);
        sendEmail(this.send);
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        clearToWhom();

    }

}
