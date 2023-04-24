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

public class ShoppingCartPage extends BaseClass {
    protected static final FluentWait fluentwait = new FluentWait(driver)
            .withTimeout(Duration.ofSeconds(60))
            .pollingEvery(Duration.ofMillis(200))
            .ignoring(Exception.class);

    protected static WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));


    public ShoppingCartPage() throws IOException {
        super();
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="div.CartList_quantityButton__aONjX > div > button:nth-child(3)")
    WebElement increment;

    @FindBy(css="div.CartList_quantityButton__aONjX > div > button:nth-child(1)")
    WebElement decrement;
    @FindBy(css="div.PricingInfo_button__X5XGu > button")
    WebElement nextBtn;

    @FindBy(css="form > div.AddressManage_addressItems__VbXmO > div:nth-child(6) > div > div>div>input")
    WebElement city;
    @FindBy(id="mantine-r14")
    WebElement area;
    @FindBy(css="form > div.AddressManage_addressItems__VbXmO > div:nth-child(8) > input")
    WebElement address;

    @FindBy(css="div.CartList_cartRight__dKrkx > h2")
    WebElement cartProductName;

    public String verifyProductName(){
        String cartProductNameText = cartProductName.getText();
        return  cartProductNameText;
    }

    public OrderPage addOrderProduct() throws IOException, InterruptedException {
        for(int i=1;i<=2;i++){
            wait.until(ExpectedConditions.elementToBeClickable(increment));
            increment.click();
        }
        //Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(decrement));
        decrement.click();
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
        nextBtn.click();
        Thread.sleep(2000);
        return new OrderPage();

    }

}
