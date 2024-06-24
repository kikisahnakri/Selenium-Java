package pageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ObjectLandingPage {

    WebDriver driver;

    public ObjectLandingPage(WebDriver driver) {
        this.driver = driver;
    }


    //String ActualElementGaming = driver.findElement(By.xpath("//a[.='Gaming Stream Highlights']")).getText();


    public void moveToFeatures() {
        Actions act=new Actions(driver);
        WebElement moveToFeatures=driver.findElement(By.xpath("//a[.='Features']"));
        act.moveToElement(moveToFeatures).build().perform();
    }

    public void verifyElementMenuFeatures(){
        String ActualElementGaming = driver.findElement(By.xpath("//a[.='Gaming Stream Highlights']")).getText();
        Assert.assertEquals("Gaming Stream Highlights",ActualElementGaming);

        String ActualElementContentPublisher= driver.findElement(By.xpath("//a[.='Content Publisher']")).getText();
        Assert.assertEquals("Content Publisher",ActualElementContentPublisher);

        String ActualElementAiBeta = driver.findElement(By.xpath("//a[.='AI-Edit (Beta)']")).getText();
        Assert.assertEquals("AI-Edit (Beta)",ActualElementAiBeta);

        String ActualElementEklipseStudio = driver.findElement(By.xpath("//a[.='Eklipse Studio']")).getText();
        Assert.assertEquals("Eklipse Studio",ActualElementEklipseStudio);

        String ActualElementVoiceCommend = driver.findElement(By.xpath("//a[.='Voice Command']")).getText();
        Assert.assertEquals("Voice Command",ActualElementVoiceCommend);

        String ActualElementMobileApp = driver.findElement(By.xpath("//a[.='Mobile App']")).getText();
        Assert.assertEquals("Mobile App",ActualElementMobileApp);

    }

    public void clickGamingStreamHight(){
        Actions act=new Actions(driver);
        WebElement gamingStream=driver.findElement(By.xpath("//a[.='Gaming Stream Highlights']"));
        act.moveToElement(gamingStream).click().build().perform();
    }

    public void verifyLandingPageOfGamingStreamHight() {
        String ActualHeading1 = driver.findElement(By.xpath("//h1[@class='elementor-heading-title elementor-size-default']")).getText();
        Assert.assertEquals("Turn Gaming Streams into TikToks with AI", ActualHeading1);

    }


    //element click
    public void clickGamingStreat(){
        Actions act=new Actions(driver);
        WebElement gamingStream=driver.findElement(By.xpath("//a[.='Gaming Stream Highlights']"));
        act.moveToElement(gamingStream).click().build().perform();
    }
}
