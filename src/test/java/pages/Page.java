package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver,20);

    }

    public void open(String url){
        driver.navigate().to(url);
    }

    public void close(){
        driver.close();
    }

    public boolean isOnThisPage(String url){
        return driver.getCurrentUrl().equals(url);
    }
}
