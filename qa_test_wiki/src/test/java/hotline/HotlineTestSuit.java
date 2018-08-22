package hotline;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HotlineTestSuit {

    private WebDriver driver;
    private HotlineMainPage searchInput;

    @Before
    public void driverSetup(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://hotline.ua/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        }

     @Test
    public void verifyHotlineNumber () throws InterruptedException {
        HotlineMainPage hotlineMainPage = new HotlineMainPage(driver);
        HotlineSearchResult hotlineSearchResult = new HotlineSearchResult(driver);
        Assert.assertEquals("3", hotlineSearchResult.getText()  );

     }



    @After
    public void closeBrowser(){
        driver.close();
    }
}
