package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import static helpers.EmailPageSendMSSelectors.*;


public class EmailPageSendMS extends  Page {

    @FindBy(how = How.XPATH,using = SENT_TITLE)
    private WebElement sentTitle;


    public EmailPageSendMS(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public String mailSentTitle(){
       return this.sentTitle.getAttribute("textContent");
    }


    public boolean isOnThisPage(){
        return  super.isOnThisPage(URL);
    }
}
