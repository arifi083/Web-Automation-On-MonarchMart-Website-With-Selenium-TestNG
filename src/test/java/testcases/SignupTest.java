package testcases;

import baseclass.BaseClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.IndexPage;
import pageobjects.SignupPage;

import java.io.IOException;

public class SignupTest extends BaseClass {
    public IndexPage indexPage;
    public SignupPage signupPage;
    public HomePage homePage;
    public SignupTest() throws IOException {
        super();
    }

    @BeforeMethod
    public void initialization() throws IOException {
        setUp();
        indexPage = new IndexPage();
        signupPage = new SignupPage();
        homePage = new HomePage();
    }

    @Test
    public void createUserAccount() throws IOException, InterruptedException {

       signupPage = indexPage.clickUserIcon();
       homePage = signupPage.createAccount(getFirstName(),getLastName(),getPhoneNumber(),getEmail(),getPassword(),getConfirmPassword());

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
