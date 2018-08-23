package hotline;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SearchResultTwoSmartPhones {

    @FindBy(xpath = "(//*[@class='tile-viewbox']//*[contains(@class,'type-checkbox')])[1]")
    private WebElement checkboxOne;

    @FindBy(xpath = "(//*[@class='tile-viewbox']//*[contains(@class,'type-checkbox')])[2]")
    private WebElement checkboxTwo;

    @FindBy(xpath = "//div[@class='item-compare']/span")
    private WebElement comparisonButton;

    @FindBy(xpath = "//div[@data-dropdown-id='compare']")
    private WebElement compare;

    @FindBy(xpath = "//a[contains(text(),'Смартфоны и мобильные телефоны')]")
    private WebElement finalComparisonButton;



    private static WebDriver driver;
    private static WebDriverWait wait;

    public SearchResultTwoSmartPhones(final WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

        clickCheckboxs(driver);


    }

    public void clickCheckboxs(final WebDriver driver){
       wait = new WebDriverWait(driver,30);

       wait.until(ExpectedConditions.visibilityOf(checkboxOne));
       checkboxOne.click();

       wait.until(ExpectedConditions.visibilityOf(checkboxTwo));
       checkboxTwo.click();

       ((JavascriptExecutor) driver).executeScript("scroll(255, 0)");

       wait.until(ExpectedConditions.visibilityOf(comparisonButton));
       comparisonButton.click();

       wait.until(ExpectedConditions.visibilityOf(finalComparisonButton));

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", finalComparisonButton);

    }
}
