package cura;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class MakeAppointmentTest {

    WebDriver driver;

    @BeforeTest
    private void init(){
        System.setProperty("webdriver.chrome.driver","C:/Drivers/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        driver.manage().window().maximize();

        //login
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"login\"]/div/div/div[1]/h2")).getText(),"Login");
        driver.findElement(By.id("txt-username")).sendKeys("John Doe");
        driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.id("btn-login")).click();
    }

    @Test (priority = 0)
    private void checkElement(){
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"appointment\"]/div/div/div/h2")).getText(),"Make Appointment");

        //check dropdown element
        Select dropDownFacility = new Select(driver.findElement(By.id("combo_facility")));
        List<WebElement> dropdownOptions = dropDownFacility.getOptions();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"appointment\"]/div/div/form/div[1]/label")).getText(),"Facility");
        Assert.assertEquals(dropdownOptions.get(0).getAttribute("value"),"Tokyo CURA Healthcare Center");
        Assert.assertEquals(dropdownOptions.get(1).getAttribute("value"),"Hongkong CURA Healthcare Center");
        Assert.assertEquals(dropdownOptions.get(2).getAttribute("value"),"Seoul CURA Healthcare Center");

        //check text area
        Assert.assertEquals(driver.findElement(By.id("txt_comment")).getAttribute("placeholder"),"Comment");
    }

    @Test (priority = 1)
    private void makeAppointmentWithCorrectValues(){
        //click dropdown
        Select dropDownFacility = new Select(driver.findElement(By.id("combo_facility")));
        dropDownFacility.selectByValue("Hongkong CURA Healthcare Center");

        //check box
        driver.findElement(By.id("chk_hospotal_readmission")).click();

        //radio button
        driver.findElement(By.id("radio_program_medicaid")).click();

        //date picker
        driver.findElement(By.id("txt_visit_date")).sendKeys("22/05/2025");

        //text area
        driver.findElement(By.id("txt_comment")).sendKeys("test text area");

        //click button submit
        driver.findElement(By.id("btn-book-appointment")).click();

    }

    @Test (priority = 2, dependsOnMethods = {"makeAppointmentWithCorrectValues"})
    private void checkAppointmentSummary() {

        //verify dropdown facility
        Assert.assertEquals(driver.findElement(By.id("facility")).getText(),"Hongkong CURA Healthcare Center");

        //check box
        Assert.assertEquals(driver.findElement(By.id("hospital_readmission")).getText(),"Yes");

        //verify healthcare/radio button
        Assert.assertEquals(driver.findElement(By.id("program")).getText(),"Medicaid");

        //verify date
        Assert.assertEquals(driver.findElement(By.id("visit_date")).getText(),"22/05/2025");

        //verify text area
        Assert.assertEquals(driver.findElement(By.id("comment")).getText(),"test text area");


        //get current url
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/appointment.php#summary");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"summary\"]/div/div/div[1]/h2")).getText(),"Appointment Confirmation");

        //go to homepage button
        driver.findElement(By.className("btn-default")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/");
    }

    @AfterTest
    private void closeBrowser() {
        driver.close();
    }



}
