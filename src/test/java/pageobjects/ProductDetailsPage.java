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

public class ProductDetailsPage extends BaseClass {
    protected static final FluentWait fluentwait = new FluentWait(driver)
            .withTimeout(Duration.ofSeconds(60))
            .pollingEvery(Duration.ofMillis(200))
            .ignoring(Exception.class);

    protected static WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));

    public ProductDetailsPage() throws IOException {
        super();
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="div.ProductInfoSection_left__RwkfQ > div.ProductInfoSection_QunatlityChangeButton__xo5gt > div > div > button")
    WebElement addToCart;

    @FindBy(css="div.Header_buttons__P3AA7 > div:nth-child(3) > button")
    WebElement cartIcon;

    @FindBy(css="div.ProductInfoSection_productTopSection__bv3Qz > div.ProductInfoSection_productLeft__figyH > h1")
    WebElement productName;

    @FindBy(css="div.CheckBox_CheckBox__bIp1T")
    WebElement cartCheckbox;

    @FindBy(css="div.ShoppingCart_button__o8ZqB > button")
    WebElement checkout;





    public String verifyProductName(){
        String productNameText = productName.getText();
        return  productNameText;
    }


    public ShoppingCartPage clickAddToCart() throws IOException {
        wait.until(ExpectedConditions.elementToBeClickable(addToCart));
        addToCart.click();
        wait.until(ExpectedConditions.elementToBeClickable(cartCheckbox));
        cartCheckbox.click();
        wait.until(ExpectedConditions.elementToBeClickable(checkout));
        checkout.click();
        return new ShoppingCartPage();

    }

    public ShoppingCartPage clickCartIcon() throws IOException {
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
        cartIcon.click();
        wait.until(ExpectedConditions.elementToBeClickable(cartCheckbox));
        cartCheckbox.click();
        wait.until(ExpectedConditions.elementToBeClickable(checkout));
        checkout.click();
        return new ShoppingCartPage();

    }



}
