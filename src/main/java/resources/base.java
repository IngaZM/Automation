package resources;

//import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.chrome.ChromeOptions;

public class base {
    public static WebDriver driver;
    public Properties prop;

    public WebDriver initializeDriver() throws IOException {

         prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resources/data.properties");

        prop.load(fis);
        String browserName = System.getProperty("browser");
        //String browserName = prop.getProperty("browser");
        System.out.println(browserName);

        if (browserName.contains("chrome")) {
            // execute in Chrome browser
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            if (browserName.contains("chromeheadless")) {
                options.addArguments("headless");
            }

            driver = new ChromeDriver(options);
        }
        else if (browserName.equals("firefox")) {
            // execute in Firefox driver
        }
        else if (browserName.equals("IE")) {
            // execute in Internet Explorer
        }

      //  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10, 1));
        return driver;

    }

    public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException{
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir")+"/reports/"+testCaseName+".png";
        FileUtils.copyFile(source, new File(destinationFile));
        return destinationFile;
    }

}
