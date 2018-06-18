package tests;
import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

import application.Application;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {

    protected static WebDriver driver;
    protected static Application application;

    @ClassRule
    public static ExternalResource driverRule = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            application=new Application(driver);

        }

        @Override
        protected void after() {
            application=null;
           if (driver != null) {
                driver.quit();
            }
        }
    };

    @Rule
    public TestWatcher screenshotRule = new TestWatcher() {
        @Override
        protected void succeeded(Description description) {
            super.starting(description);
        }

        @Override
        protected void failed(Throwable e, Description description) {
            System.out.println("Taking sceenshot");
            File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                Files.copy(tmp, new File("src/test/screenshots "+ description.getMethodName()
                        + System.currentTimeMillis() +".png"));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        @Override
        protected void starting(Description description) {
            super.starting(description);
        }

        @Override
        protected void finished(Description description) {
            super.finished(description);
        }
    };

}