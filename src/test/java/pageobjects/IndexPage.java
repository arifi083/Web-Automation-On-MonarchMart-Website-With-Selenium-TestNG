package pageobjects;

import baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class IndexPage extends BaseClass {
    protected static final FluentWait fluentwait = new FluentWait(driver)
            .withTimeout(Duration.ofSeconds(60))
            .pollingEvery(Duration.ofMillis(200))
            .ignoring(Exception.class);


    protected static final WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));

    @FindBy(css="div.Header_mainLogo__nYQyd > a > img")
    WebElement monarchmartLogo;

    @FindBy(css="div.Header_buttons__P3AA7 > div:nth-child(4) > button > div")
    WebElement userIcon;

    public IndexPage() throws IOException {
        super();
        PageFactory.initElements(driver,this);
    }

    public boolean validateLogo(){
       return monarchmartLogo.isDisplayed();
    }

    public String verifyTitle(){
        String monarchmarttitle = driver.getTitle();
        System.out.println(monarchmarttitle);
        return monarchmarttitle;
    }

    public SignupPage clickUserIcon() throws IOException {
         userIcon.click();
         return new SignupPage();
    }

}
