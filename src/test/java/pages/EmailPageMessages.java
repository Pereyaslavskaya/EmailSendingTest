package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static helpers.EmailPageMessagesSelectors.WRITE_LETTER_LINK;

public class EmailPageMessages extends Page {

    @FindBy(how= How.CSS,using =WRITE_LETTER_LINK)
    private WebElement writeLetterLink;


    public EmailPageMessages(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public EmailPageCompose createNewMessage(){
        this.writeLetterLink.click();
        return new EmailPageCompose(driver);
    }
}
