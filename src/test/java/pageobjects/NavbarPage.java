package pageobjects;

import baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class NavbarPage extends BaseClass {
    protected static final FluentWait fluentwait = new FluentWait(driver)
            .withTimeout(Duration.ofSeconds(60))
            .pollingEvery(Duration.ofMillis(200))
            .ignoring(Exception.class);


    protected static WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));

    public NavbarPage() throws IOException {
        super();
        PageFactory.initElements(driver,this);
    }

    @FindBy(css ="div.Header_allCategoriesButton__FO9OJ")
    WebElement categories;
    @FindBy(css="ul.MenuBar_CategoryList__xn3ZO.MenuBar_categoryList__beJ_5.MenuBar_base__aG48Q.scrollbar-ui>li:nth-child(2)")
    WebElement fashion;
    @FindBy(css ="div.Header_desktopMenu___m5cd > div > div > div > div > div > div > ul:nth-child(2) > li:nth-child(3) > a")
    WebElement woman;


    public ProductPage navigation() throws IOException, InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(categories).build().perform();
        actions.moveToElement(fashion).build().perform();

       // wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(woman));
        actions.moveToElement(woman);
        actions.click().build().perform();
        Thread.sleep(10000);
        return new ProductPage();

    }
}
