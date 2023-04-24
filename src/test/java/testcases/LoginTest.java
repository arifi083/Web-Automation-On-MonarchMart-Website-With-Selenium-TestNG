package testcases;

import baseclass.BaseClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import java.io.IOException;

public class LoginTest extends BaseClass {

    public LoginPage loginPage;
    public HomePage homePage;
;
    public LoginTest() throws IOException {
        super();
    }

    @BeforeMethod
    public void initialization() throws IOException {
        setUp();
        loginPage = new LoginPage();
        homePage = new HomePage();
    }

    @Test
    public void validlogin() throws IOException, InterruptedException {
        homePage =loginPage.login(getEmail(),getPassword());;
        homePage.flashSaleText();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
