package testcases;

import baseclass.BaseClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.IndexPage;
import pageobjects.LoginPage;
import pageobjects.SignupPage;

import java.io.IOException;

public class HomeTest extends BaseClass {

    public HomePage homePage;
    public LoginPage loginPage;
    public SignupPage signupPage;
    public IndexPage indexPage;
    public HomeTest() throws IOException {
        super();
    }

    @BeforeMethod
    public void initialization() throws IOException {
        setUp();
        homePage = new HomePage();
        loginPage = new LoginPage();
        signupPage = new SignupPage();
        indexPage = new IndexPage();
    }

    @Test
    public void verifyHomePage() throws IOException, InterruptedException {
        signupPage = indexPage.clickUserIcon();
        homePage = signupPage.createAccount(getFirstName(),getLastName(),getPhoneNumber(),getEmail(),getPassword(),getConfirmPassword());
        homePage.clickRegisterBtn();
        homePage.flashSaleText();
        loginPage = homePage.logout();


    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
