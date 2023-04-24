package pageobjects;

import baseclass.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class ProductPage extends BaseClass {
    protected static final FluentWait fluentwait = new FluentWait(driver)
            .withTimeout(Duration.ofSeconds(60))
            .pollingEvery(Duration.ofMillis(200))
            .ignoring(Exception.class);


    protected static WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));

    public ProductPage() throws IOException {
        super();
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="#id123 > div.ProductsSection_buttons__Oj260 > div > button:nth-child(4)")
    WebElement highToLow;

    @FindBy(css ="div.ProductsSection_filters__XcWiu > div:nth-child(1) > div > div:nth-child(3) > div")
    WebElement clothings;

    @FindBy(css="div.ProductsSection_filters__XcWiu > div:nth-child(2) > div > div:nth-child(3) > div")
    WebElement rating;
    @FindBy(css="div:nth-child(3) > div > div.ProductCard_cardBody__pXjUI > a")
    WebElement productName;



    public ProductDetailsPage productSearching() throws IOException, InterruptedException {
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement pricehtol = wait.until(ExpectedConditions.elementToBeClickable(highToLow));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", pricehtol);

        wait.until(ExpectedConditions.elementToBeClickable(clothings));
        clothings.click();
        //Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(rating));
        rating.click();
        this.scroll1();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(productName));
        productName.click();
        return new ProductDetailsPage();

    }


    public void scroll1() throws InterruptedException {
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scroll(0,205)");
        Thread.sleep(2000);
    }
}
