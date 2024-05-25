package Pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import static Tests.SeleniumTest.driver;

public class HomePage {

    //Xpath in humberger menu
    public static String humberger_menu_xpath = "//*[@id=\"menuToggle\"]/input";
    public static String onlineProducts_xpath = "//*[@id=\"menu\"]/a[3]/li";
    public static String signInPortal_xpath = "//*[@id=\"menu\"]/a[2]/li";
    public static String about_xpath = "//*[@id=\"menu\"]/a[4]/li";
    public static String ourTeam_xpath = "//*[@id=\"menu\"]/a[5]/li";
    public static String contact_xpath = "//*[@id=\"menu\"]/a[6]/li";

    //
    public static String header_xpath ="//*[@id=\"ShoePortalTitle\"]";
    public static String center_xpath = "//*[@id=\"MainPageText\"]";
    public static String footer_xpath = "//*[@id=\"CopyrightFooter\"]";



    //element home page
    public static void verifyElementOnlineProduct()  {
        String expectedTextProduct = "Online Products";
        String actualTextProduct = driver.findElement(By.xpath(onlineProducts_xpath)).getText();
        Assert.assertEquals(actualTextProduct, expectedTextProduct);
    }
    public static void verifyElementSignInPortal() throws InterruptedException {
        Thread.sleep(2000);
        String expectedTextSignInPortal = "Sign In Portal";
        String actualTextSignInPortal = driver.findElement(By.xpath(signInPortal_xpath)).getText();
        Assert.assertEquals(actualTextSignInPortal, expectedTextSignInPortal);
    }

    public static void verifyElementAbout() {
        String expectedTextAbout = "About";
        String actualTextAbout = driver.findElement(By.xpath(about_xpath)).getText();
        Assert.assertEquals(actualTextAbout, expectedTextAbout);
    }

    public static void verifyElementOurTeam(){
            String expectedTextOurTeam = "Our Team";
            String actualTextOurTeam = driver.findElement(By.xpath(ourTeam_xpath)).getText();
            Assert.assertEquals(actualTextOurTeam, expectedTextOurTeam);
    }

    public static void verifyElelmentContact(){
        String expectedTextContact = "Contact";
        String actualTextContact= driver.findElement(By.xpath(contact_xpath)).getText();
        Assert.assertEquals(actualTextContact,expectedTextContact);
    }

    public static void verifyElementHeader(){
        String expectedTextHeader = "Ace Online Shoe Portal";
        String actualTextHeader= driver.findElement(By.xpath(header_xpath)).getText();
        Assert.assertEquals(actualTextHeader,expectedTextHeader);
    }

    public static void verifyElementCenter(){
        String expectedTextCenter = "One Stop Shop for all your Shoes needs!";
        String actualTextCenter= driver.findElement(By.xpath(center_xpath)).getText();
        Assert.assertEquals(actualTextCenter,expectedTextCenter);

    }
    public static void verifyElementFooter(){
        String expectedTextFooter = "Ace Automation © All Rights Reserved 2024";
        String actualTextFooter = driver.findElement(By.xpath(footer_xpath)).getText();
        Assert.assertEquals(actualTextFooter,expectedTextFooter);

    }




    public static void clikHumbergerMenu(){
        driver.findElement(By.xpath(humberger_menu_xpath)).click();

    }

    public static void clickOnlineProductsOnHumbergerMenu() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(onlineProducts_xpath)).click();
    }

    public static void clikAboutMenuOnHumbergerMenu(){
        driver.findElement(By.xpath(about_xpath)).click();

    }

    public static void clickOurTeamOnHumbergerMenu(){
        driver.findElement(By.xpath(ourTeam_xpath)).click();
    }

    public static void clickContactOnHumbergerMenu(){
        driver.findElement(By.xpath(contact_xpath)).click();
    }

    public static void clickSignInPortalOnHumberger(){
        driver.findElement(By.xpath(signInPortal_xpath)).click();
    }


}
