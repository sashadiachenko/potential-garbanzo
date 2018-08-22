package hotline;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotlineMainPage {
    private WebDriver driver;
    private Actions actions;
    private  WebDriverWait wait;

   @FindBy(xpath = "//*[@id='page-index']/div[1]/div[1]/div[2]/aside/nav/ul/li[18]/div/ul/li[1]/div/ul/li[1]/a/span")
    private WebElement smartfoneTelefon;

    private static final String PRODUCT_PHONE = "//*[@id='page-index']/div[1]/div[1]/div[2]/aside/nav/ul/li[18]/a";

    public HotlineMainPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        hover(driver);
        smartPhone(driver);


    }

    public void hover(final WebDriver driver){
        actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath(PRODUCT_PHONE));
        actions.moveToElement(element);
        actions.perform();

    }


    public void smartPhone(final WebDriver driver){
        wait = new WebDriverWait(driver ,30);
        wait.until(ExpectedConditions.visibilityOf(smartfoneTelefon));
        smartfoneTelefon.click();

        //return new HotlineSearchResult(driver);

    }

   /* public void navigateToSmartfone(){
        final String locator = String.format(PRODUCT_PHONE);
        final WebElement product = driver.findElement(By.xpath(locator));
        actions.moveToElement(product).build().perform();
    }


  /*  private void hover (WebElement webElement) throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(smartfoneTelefon).build().perform();
        Thread.sleep(1000000);
    }*/



}
