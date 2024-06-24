package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.*;

public class LoginKasirSteps {

    WebDriver driver;

    @Given("I am on the login page")
    public void I_am_on_the_login_page(){
        System.setProperty("webdriver.chrome.driver","C://Drivers/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();// launch browser
        driver.get("https://kasirdemo.belajarqa.com");
        driver.manage().window().maximize();
    }

    @When("I enter valid username {string} and password {string}")
    public void i_enter_valid_username_and_password(String username,String password) throws InterruptedException {
        sleep(4000);
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);

    }
    @When("I click the login button")
    public void i_click_the_login_button() throws InterruptedException {
        driver.findElement(By.xpath("//button[@class='chakra-button css-1n8i4of']")).click();
        Thread.sleep(4000);
    }
    @Then("I should see the home page")
    public void i_should_see_the_home_page() throws InterruptedException {
        Thread.sleep(3000);  // Wait for the home page to load
        String actual = driver.findElement(By.xpath("//a[@href='/dashboard']//div[@class='css-1mqa38q']")).getText();
        Assert.assertEquals("dashboard",actual);

    }

    @And("close browser")
    public void closeBrowser() {
        driver.quit();
    }
//===========================================
    @When("I enter invalid username {string} and valid password {string}")
    public void i_enter_invalid_username_and_password(String username, String password) {
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
    }

    @Then("I should see an error message")
    public void i_should_see_an_error_message() throws InterruptedException {
        Thread.sleep(3000);  // Wait for the home page to load
        String expectation1 = "Kredensial yang Anda berikan salah";
        String expectation2 = "\"email\" is not allowed to be empty";
        String actual = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/div[1]")).getText();
        if (actual.equals(expectation1)) {  // Replace with a more reliable check if necessary
            Assert.assertEquals(expectation1,actual);
            System.out.println("expec : "+expectation1 +" actual :"+actual);
        } else if (actual.equals(expectation2) ){
            Assert.assertEquals(expectation2,actual);
            System.out.println("expec : "+expectation2 +" actual :"+actual);
        }else{
            Assert.assertEquals(expectation2,actual);
            driver.close();
        }
    }

    @When("I enter valid username {string} and invalid password {string}")
    public void i_enter_invalid_username_and_valid_password(String username, String password) {
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
    }

    @When("I enter blank username {string} and blank password {string}")
    public void i_enter_blank_username_and_blank_password(String username, String password) {
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
    }

}
