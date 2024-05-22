package cura;

import net.bytebuddy.build.Plugin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTest {

    WebDriver driver;

    @BeforeTest
    private void init(){
        System.setProperty("webdriver.chrome.driver","C:/Drivers/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        driver.manage().window().maximize();
    }

    @Test (priority = 0)
    private void loginWithNullValues(){
        driver.findElement(By.id("btn-login")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"login\"]/div/div/div[1]/p[2]")).getText(),"Login failed! Please ensure the username and password are valid.");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"login\"]/div/div/div[1]/p[1]")).getText(),"Please login to make appointment.");
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/profile.php#login");
        Assert.assertEquals(driver.getTitle(),"CURA Healthcare Service");

    }

    @Test (priority = 1)
    private void loginWithWrongValues(){
        driver.findElement(By.id("txt-username")).sendKeys("John Doe");
        driver.findElement(By.id("txt-password")).sendKeys("worngvaluess");
        driver.findElement(By.id("btn-login")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"login\"]/div/div/div[1]/p[2]")).getText(),"Login failed! Please ensure the username and password are valid.");
    }

    @Test (priority = 2)
    private void loginWithCorrectValues(){
        Assert.assertEquals(driver.findElement(By.xpath("//div[1]/h2")).getText(),"Login");
        driver.findElement(By.id("txt-username")).sendKeys("John Doe");
        driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.id("btn-login")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"appointment\"]/div/div/div/h2")).getText(),"Make Appointment");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"appointment\"]/div/div/form/div[1]/label")).getText(),"Facility");
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/#appointment");

    }

    @AfterTest
    public void closeBrowser(){
        driver.close();

    }



}
