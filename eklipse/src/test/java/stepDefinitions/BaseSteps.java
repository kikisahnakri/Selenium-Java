package stepDefinitions;

import org.openqa.selenium.WebDriver;

public class BaseSteps {
    protected static WebDriver driver;

    public static void setDriver(WebDriver driver) {
        BaseSteps.driver = driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
