package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class UtilityMethods {


    public void enterLogin(WebElement element,String login){
        element.clear();
        element.sendKeys(login);
    }

    public void selectDomain(WebElement element,String domain){
        Select select=new Select(element);
        select.selectByVisibleText(domain);
    }

    public void setDomain(WebDriver driver,WebElement element, WebElement option){
        new Actions(driver)
                .moveToElement(element).click()
                .moveToElement(option).click().build().perform();

    }

    public void enterPassword (WebElement element,String password){
        element.clear();
        element.sendKeys(password);
    }

    public void submit(WebElement element){
        element.click();
    }

    public void waitFullFrameLoading(WebDriver driver,Long time) {
        new WebDriverWait(driver, time, 200).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver)
                        .executeScript("return document.readyState")
                        .equals("complete");
            }
        });
    }



}
