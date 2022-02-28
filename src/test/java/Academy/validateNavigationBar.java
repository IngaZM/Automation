package Academy;

import PageObject.LandingPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.base;

import java.io.IOException;
// Adding logs
// Generating HTML reports
// Screenshots on failure
// Jenkins integration

public class validateNavigationBar extends base {
    public WebDriver driver;
    public static Logger log = LogManager.getLogger(base.class.getName());

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
    }
    @Test
    public void basePageNavigation() throws IOException {
        // one is inheritance
        // creating object to that class and involve methods of it
        LandingPage l = new LandingPage(driver);
        //
        Assert.assertTrue(l.getNavigationBar().isDisplayed());
        log.info("Navigation bar is displayed");
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }



}
