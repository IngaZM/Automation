package Academy;

import PageObject.LandingPage;
import PageObject.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import resources.base;

import java.io.IOException;

public class validateTitle extends base {
    public WebDriver driver;
    public static Logger log = LogManager.getLogger(base.class.getName());
    LandingPage l;
    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        log.info("Driver is initialized");

        driver.get(prop.getProperty("url"));
        log.info("Navigated to Home page");
    }

    @Test
    public void basePageNavigation() throws IOException {
        // one is inheritance
        // creating object to that class and involve methods of it
         l = new LandingPage(driver);
        // compare the text from the browser with actual text.- Error..
        Assert.assertEquals(l.getTitle().getText(),"FEATURED COURSES");
        log.info("Successfully validated Text message");
    }

    @Test
    public void validateHeader() {
        Assert.assertEquals(l.getHeader().getText(), "FEATURED COURSES");
        log.info("AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
        System.out.println("Test completed");
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }



}
