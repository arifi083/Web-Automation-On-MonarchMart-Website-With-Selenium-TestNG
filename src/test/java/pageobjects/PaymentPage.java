package pageobjects;

import baseclass.BaseClass;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class PaymentPage extends BaseClass {
    protected static final FluentWait fluentwait = new FluentWait(driver)
            .withTimeout(Duration.ofSeconds(60))
            .pollingEvery(Duration.ofMillis(200))
            .ignoring(Exception.class);

    protected static WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));


    public PaymentPage() throws IOException {
        super();
        PageFactory.initElements(driver,this);
    }
}
