package Pages;

import org.openqa.selenium.By;

import static Tests.SeleniumTest.driver;

public class HomePage {

    public static String humberger_menu_xpath = "//*[@id=\"menuToggle\"]/input";

    public static String onlineProducts_link_xpath = "//*[@id=\"menu\"]/a[3]/li";


    public static void clik_humberger_menu(){
        driver.findElement(By.xpath(humberger_menu_xpath)).click();

    }

    public static void clik_OnlineProducts_link() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(onlineProducts_link_xpath)).click();
    }


}
