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

public class SignupPage extends BaseClass {
    protected static final FluentWait fluentwait = new FluentWait(driver)
            .withTimeout(Duration.ofSeconds(60))
            .pollingEvery(Duration.ofMillis(200))
            .ignoring(Exception.class);


    protected static final WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));

    public SignupPage() throws IOException {
        super();
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="div.login_haveAccount__63xq5 > h2 > a > button")
    WebElement signupBtn;

    @FindBy(xpath = "//input[@placeholder='Write your first name']")
    WebElement firstName;

    @FindBy(xpath ="//input[@placeholder='Write your last name']")
    WebElement lastName;

    @FindBy(css="form > div:nth-child(3) > div > input")
    WebElement phoneNumber;

    @FindBy(css="form > div:nth-child(4) > input[type=email]")
    WebElement email;

    @FindBy(css="form > div:nth-child(5)>div>div>div>input")
    WebElement password;

    @FindBy(css="form > div:nth-child(6)>div>div>div>input")
    WebElement confirmPassword;

    @FindBy(css="form > div.login_checkboxes__WANDK > div > input[type=checkbox]")
    WebElement checkBox;




    public HomePage createAccount(String fName,String lName,String phn,String mail,String pass,String cpass) throws InterruptedException, IOException {
        this.scroll1();
        signupBtn.click();
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        phoneNumber.sendKeys(phn);
        email.sendKeys(mail);
        this.scroll1();
        password.sendKeys(pass);
        Thread.sleep(2000);
        confirmPassword.sendKeys(cpass);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(checkBox));
        checkBox.click();
        Thread.sleep(3000);
        return new HomePage();

    }


    public void scroll1() throws InterruptedException {
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scroll(0,315)");
        Thread.sleep(2000);
    }



}
