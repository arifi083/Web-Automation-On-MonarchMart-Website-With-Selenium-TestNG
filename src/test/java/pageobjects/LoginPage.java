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

public class LoginPage extends BaseClass {
    protected static final FluentWait fluentwait = new FluentWait(driver)
            .withTimeout(Duration.ofSeconds(60))
            .pollingEvery(Duration.ofMillis(200))
            .ignoring(Exception.class);


    protected static final WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));

    public LoginPage() throws IOException {
        super();
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="div.Header_buttons__P3AA7 > div:nth-child(4) > button > div")
    WebElement userIcon;
    @FindBy(css="form > div:nth-child(1) > input[type=text]")
    WebElement email;
    @FindBy(css="form > div:nth-child(2) > input[type=password]")
    WebElement password;

    @FindBy(css="div.login_Login__2e3DX > div > div > form > button")
    WebElement loginBtn;


    public HomePage login(String mail,String pass) throws IOException, InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(userIcon));
        userIcon.click();
        email.sendKeys(mail);
        Thread.sleep(2000);
        password.sendKeys(pass);
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        loginBtn.click();
        Thread.sleep(2000);
        return new HomePage();
    }


}
