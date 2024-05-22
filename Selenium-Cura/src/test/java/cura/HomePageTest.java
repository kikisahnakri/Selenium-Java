package cura;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest {

    WebDriver driver;

    @BeforeTest
    private void init(){
        //initiate browser
        System.setProperty("webdriver.chrome.driver","C:/Drivers/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();

        //go to home page
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
    }

    @Test (priority = 0)
    private void checkElement(){
        //check h1 element
        Assert.assertEquals(driver.findElement(By.cssSelector("header h1")).getText(),"CURA Healthcare Service");
        Assert.assertEquals(Color.fromString(driver.findElement(By.cssSelector("header h1")).getCssValue("color")).asHex(),"#ffffff");

        //check h3 element
        Assert.assertEquals(driver.findElement(By.cssSelector("header h3")).getText(),"We Care About Your Health");
        Assert.assertEquals(Color.fromString(driver.findElement(By.cssSelector("header h3")).getCssValue("color")).asHex(),"#4fb6e7");

        //check button
        Assert.assertEquals(driver.findElement(By.id("btn-make-appointment")).getText(),"Make Appointment");
        Assert.assertEquals(driver.findElement(By.id("btn-make-appointment")).getCssValue("background-color"),"rgba(115, 112, 181, 0.8)");

        //check toggle menu
        Assert.assertEquals(driver.findElement(By.id("menu-toggle")).getCssValue("background-color"),"rgba(115, 112, 181, 0.8)");
    }

    @Test (priority = 1)
    private void clikToggleMenu(){
        driver.findElement(By.xpath("//*[@id=\"menu-toggle\"]")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[1]")).getText(),"CURA Healthcare");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[2]")).getText(),"Home");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[3]")).getText(),"Login");
    }

    @Test (priority = 2)
    private void clickButtonAppointment(){
        driver.findElement(By.id("btn-make-appointment")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//p[@class='lead']")).getText(),"Please login to make appointment.");
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/profile.php#login");

    }

    @AfterTest
    private  void exitChrome(){
        driver.close();
    }
}
