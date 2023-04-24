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

public class HomePage extends BaseClass {
    protected static final FluentWait fluentwait = new FluentWait(driver)
            .withTimeout(Duration.ofSeconds(60))
            .pollingEvery(Duration.ofMillis(200))
            .ignoring(Exception.class);


    protected static final WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));

    public HomePage() throws IOException {
        super();
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="div.SectionHeader_sectionHeader__p2hw9 > div > div > div > h2")
    WebElement flashSale;

    @FindBy(css="div.Header_buttons__P3AA7 > div:nth-child(4) > button > div")
    WebElement userIcon;

    @FindBy(css="div.Header_buttons__P3AA7 > div:nth-child(4) > div > button")
    WebElement logoutBtn;

    @FindBy(css="div.login_Login__2e3DX > div > div > form > button")
    WebElement registerBtn;

    public boolean flashSaleText(){
        return flashSale.isDisplayed();
    }

    public void clickRegisterBtn() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(registerBtn));
        registerBtn.click();
        Thread.sleep(3000);
    }

    public LoginPage logout() throws IOException, InterruptedException {
        Thread.sleep(3000);
        System.out.println("arif");
        wait.until(ExpectedConditions.elementToBeClickable(userIcon));
        userIcon.click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(logoutBtn));
        logoutBtn.click();
        Thread.sleep(3000);
        return new LoginPage();
    }



}
