package Academy;

import PageObject.ForgotPassword;
import PageObject.LandingPage;
import PageObject.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import resources.base;

import java.io.IOException;

public class HomePage extends base {
    public WebDriver driver;
    public static Logger log = LogManager.getLogger(base.class.getName());

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();

    }

    @Test(dataProvider="getData")
    public void basePageNavigation(String Username, String Password, String text) throws IOException {
        // one is inheritance
        // creating object to that class and involve methods of it
        driver.get(prop.getProperty("url"));
        LandingPage l = new LandingPage(driver);
        LoginPage lp = l.getLogin(); // driver.findElement(By.css)
        //LoginPage lp = new LoginPage(driver);
        lp.getEmail().sendKeys("abs@yahooh.com");
        lp.getPassword().sendKeys("1245");
        //System.out.println(text);
        log.info(text);
        lp.getLogin().click();
        ForgotPassword fp = lp.setForgotPassword();
        fp.getEmail().sendKeys("em@gmail.com");
        fp.sendMeInstructions().click();
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }

    @DataProvider
    public Object[][] getData() {
        // Row stands for how many dff data types test should run
        // column stands for how many values per test
        Object[][] data = new Object[2][3];
        // 0th row
        data[0][0] = "nonrestricteduser@nu.com";
        data[0][1] = "pass0";
        data[0][2] = "Restricted User";

        // 1st row
        data[1][0] = "restricteduser@ru.com";
        data[1][1] = "pass1";
        data[1][2] = "Non Restricted User";


        return data;

    }

}
