package Pages;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import static Tests.SeleniumTest.driver;
import static Tests.SeleniumTest.*;

public class ProductPages {
    public static String formalShoesTitle_xpath = "/html/body/div[2]/center/h2";
    public static String sportShoesTitle_xpath = "/html/body/div[3]/center/h2";
    public static String sneakersTitle_xpath = "/html/body/div[4]/center/h2";

    public static String dropDownFormalShoes_xpath = "/html/body/div[2]/center/div/i[1]";
    public static String dropDownSportShoes_xpath = "/html/body/div[3]/center/div/i[1]";
    public static String dropDownSneakers_xpath = "/html/body/div[4]/center/div/i[1]";

    //
    public static String formalShoes_firstShoes_xpath = "/html/body/div[2]/table/tbody/tr[1]/td[1]";
    public static String sportShoes_firstShoes_xpath = "/html/body/div[3]/table/tbody/tr[1]/td[1]";
    public static String sneakers_firstShoes_xpath = "/html/body/div[4]/table/tbody/tr[1]/td[1]";




    public static void formalShoes_VerifyTitle() {
        String expectedTitleFS = "Formal Shoes";
        String actualTitleFS = driver.findElement(By.xpath(formalShoesTitle_xpath)).getText();
        if (expectedTitleFS.equals(actualTitleFS)){
            test.log(Status.PASS,"Test Passed for title verification Formal Shoes Expectation :"+expectedTitleFS+" = Actual "+actualTitleFS);
            test.log(Status.PASS,test.addScreenCaptureFromPath(capture(driver),actualTitleFS)+" Passed ");
        }else{
            //test.fail(MediaEntityBuilder.createScreenCaptureFromBase64String("base64").build());
            test.log(Status.FAIL,test.addScreenCaptureFromPath(capture(driver))+ "Test Failed");
        }
        Assert.assertEquals(actualTitleFS,expectedTitleFS);
    }

    public static void sportShoesTitle_VerifyTitle(){
        String expectedTitleSS = "Sports Shoes";
        String actualTitleSS = driver.findElement(By.xpath(sportShoesTitle_xpath)).getText();
        if (expectedTitleSS.equals(actualTitleSS)){
            test.log(Status.PASS,"Test Passed for title verification Sports Shoes Expectation :"+expectedTitleSS+" = Actual "+actualTitleSS);
            test.log(Status.PASS,test.addScreenCaptureFromPath(capture(driver),actualTitleSS)+" Passed ");
        }else{
         //   test.log(Status.FAIL,"Test Failed for title verification of Sports Shoes");
            test.log(Status.FAIL,test.addScreenCaptureFromPath(capture(driver))+ "Test Failed = " +actualTitleSS);
        }
        Assert.assertEquals(actualTitleSS,expectedTitleSS);
    }

    public static void sneakersTitle_VerifyTitle(){
        String expectedTitleSn = "Sneakers";
        String actualTitleSn = driver.findElement(By.xpath(sneakersTitle_xpath)).getText();
        if (expectedTitleSn.equals(actualTitleSn)){
            test.log(Status.PASS,"Test Passed for title verification Expectation :"+expectedTitleSn+" = Actual "+actualTitleSn);
            test.log(Status.PASS,test.addScreenCaptureFromPath(capture(driver),actualTitleSn)+" Passed ");
        }else{
            //test.log(Status.FAIL,"Test Failed for title verification of Sneaker Shoes");
            test.log(Status.FAIL,test.addScreenCaptureFromPath(capture(driver))+ "Test Failed = " +actualTitleSn);
        }
        Assert.assertEquals(actualTitleSn,expectedTitleSn);
    }

    public static void formalShoes_verify(){
        driver.findElement(By.xpath(dropDownFormalShoes_xpath)).click();
        String expectedFirstShoesFS = "   Classic Cheltenham";
        String actualFirstShoesFS = driver.findElement(By.xpath(formalShoes_firstShoes_xpath)).getText();
        if (expectedFirstShoesFS.equals(actualFirstShoesFS)){
            test.log(Status.PASS,"Test Passed for first shoes on Formal Shoes Expectation :"+expectedFirstShoesFS+" = Actual "+actualFirstShoesFS);
            test.log(Status.PASS,test.addScreenCaptureFromPath(capture(driver),actualFirstShoesFS)+" Passed ");
        }else{
         //   test.log(Status.FAIL,"Test Failed for title verification of Formal Shoes");
            test.log(Status.FAIL,test.addScreenCaptureFromPath(capture(driver))+ "Test Failed = " +actualFirstShoesFS);
        }
        Assert.assertEquals(actualFirstShoesFS,expectedFirstShoesFS);

    }

    public static void sportShoes_verify(){
        driver.findElement(By.xpath(dropDownSportShoes_xpath)).click();
        String expectedFirstShoesSS = "   Ultimate";
        String actualFirstShoesSS = driver.findElement(By.xpath(sportShoes_firstShoes_xpath)).getText();
        if (expectedFirstShoesSS.equals(actualFirstShoesSS)){
            test.log(Status.PASS,"Test Passed for first shoes on Sport Shoes Expectation :"+expectedFirstShoesSS+" = Actual "+actualFirstShoesSS);
            test.log(Status.PASS,test.addScreenCaptureFromPath(capture(driver),actualFirstShoesSS)+" Passed ");
        }else{
          //  test.log(Status.FAIL,"Test Failed for title verification of Sport Shoes");
            test.log(Status.FAIL,test.addScreenCaptureFromPath(capture(driver))+ "Test Failed = " +actualFirstShoesSS);
        }
        Assert.assertEquals(actualFirstShoesSS,expectedFirstShoesSS);
    }

    public static void sneakers_verify(){
        driver.findElement(By.xpath(dropDownSneakers_xpath)).click();
        String expectedFirstShoesSn = "   Archivo";
        String actualFirstShoesSn = driver.findElement(By.xpath(sneakers_firstShoes_xpath)).getText();
        if (expectedFirstShoesSn.equals(actualFirstShoesSn)){
            test.log(Status.PASS,"Test Passed for first shoes on Sneaker Shoes Expectation :"+expectedFirstShoesSn+" = Actual "+actualFirstShoesSn);
            test.log(Status.PASS,test.addScreenCaptureFromPath(capture(driver),actualFirstShoesSn)+" Passed ");
        }else{
           // test.log(Status.FAIL,"Test Failed for title verification of Sneaker Shoes");
            test.log(Status.FAIL,test.addScreenCaptureFromPath(capture(driver))+ "Test Failed");
        }
        Assert.assertEquals(actualFirstShoesSn,expectedFirstShoesSn);
    }

}
