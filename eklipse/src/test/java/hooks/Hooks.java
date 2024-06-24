package hooks;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefinitions.BaseSteps;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Hooks {

    private static WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C://Dev/Selenium Java/eklipse/src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        BaseSteps.setDriver(driver);

    }

    @After
    public void closeBrowser(Scenario scenario) throws IOException {
        WebDriver driver = BaseSteps.getDriver();
        if (scenario.isFailed() && driver != null) {
            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotBytes, "image/png", scenario.getName());
        }
        if (driver != null) {
            driver.quit();
        }
    }
}
