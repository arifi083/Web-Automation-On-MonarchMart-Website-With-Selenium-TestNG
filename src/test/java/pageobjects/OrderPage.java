package pageobjects;

import baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class OrderPage extends BaseClass {
    protected static final FluentWait fluentwait = new FluentWait(driver)
            .withTimeout(Duration.ofSeconds(60))
            .pollingEvery(Duration.ofMillis(200))
            .ignoring(Exception.class);

    protected static WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));

    public OrderPage() throws IOException {
        super();
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="div.OrderLayout_left__kEW96.undefined > textarea")
    WebElement orderNote;

    @FindBy(css="div.PricingInfo_checkboxes__ERrHC > div > div")
    WebElement orderCheckbox;

    @FindBy(css=" div.PricingInfo_button__X5XGu > button")
    WebElement placeOrder;

    public PaymentPage placeOrder(String ordNote) throws IOException, InterruptedException {
        orderNote.sendKeys(ordNote);
        //Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(orderCheckbox));
        orderCheckbox.click();;
        Thread.sleep(2000);
        return new PaymentPage();
    }
}
