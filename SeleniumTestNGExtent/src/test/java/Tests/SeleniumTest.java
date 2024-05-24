package Tests;
import Pages.HomePage;
import Pages.ProductPages;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class SeleniumTest {

    public static WebDriver driver;

    //report
    public static ExtentTest test;
    static ExtentReports extent = new ExtentReports();

    @BeforeSuite
    public static void Setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);

        driver.manage().window().maximize();

        HomePage.clik_humberger_menu();
        HomePage.clik_OnlineProducts_link();
    }

    public static String capture (WebDriver driver) {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File Dest = new File("src/../ExecImages/" + System.currentTimeMillis()
                + ".png");
        String errflpath = Dest.getAbsolutePath();
        try {
            FileUtils.copyFile(scrFile,Dest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return errflpath;
    }


    @Test
    void validateTitle_onlineProducts() throws InterruptedException{
        test = extent.createTest("Validate Shoes Title on Product Page", "This test validate that the different Shoes type are correct on Online Product Page");
        ProductPages.formalShoes_VerifyTitle();
        ProductPages.sportShoesTitle_VerifyTitle();
        ProductPages.sneakersTitle_VerifyTitle();
        extent.flush();
    }

    @Test
    void validateFirstFormalShoes(){
        test = extent.createTest("Validate first shoe name","This test validate first formal shoes on Product Page");
        ProductPages.formalShoes_verify();
    }

    @Test
    void validateFirstSportShoes(){
        test = extent.createTest("Validate first shoe name","This test validate first sport shoes on Product Page");
        ProductPages.sportShoes_verify();
    }

    @Test
    void validateFirstSneaker(){
        test = extent.createTest("Validate first shoe name","This test validate first sneaker shoes on Product Page");
        ProductPages.sneakers_verify();
    }

    @AfterSuite
    public static void cleanUp()
    {
        extent.flush();
        driver.close();
    }







}
