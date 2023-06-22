package configuration;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

public class BaseClass {
    public static WebDriver driver;

    @BeforeClass
    public static void createWebDriver() {
        driver = DriverFactory.greateDriver(WEBDRIVERS.CHROMECLEAN);
    }

    @AfterClass
    public static void endTests() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}
