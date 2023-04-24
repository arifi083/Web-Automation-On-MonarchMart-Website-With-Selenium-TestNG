package testcases;

import baseclass.BaseClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.NavbarPage;
import pageobjects.ProductPage;

import java.io.IOException;

public class NavbarTest extends BaseClass {
    public LoginPage loginPage;
    public HomePage homePage;
    public NavbarPage navbarPage;
    public ProductPage productPage;
    ;
    public NavbarTest() throws IOException {
        super();
    }

    @BeforeMethod
    public void initialization() throws IOException {
        setUp();
        loginPage = new LoginPage();
        homePage = new HomePage();
        navbarPage = new NavbarPage();
        productPage = new ProductPage();

    }

    @Test
    public void clickNavbar() throws IOException, InterruptedException {
        homePage =loginPage.login(getEmail(),getPassword());;
        homePage.flashSaleText();
        productPage = navbarPage.navigation();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
