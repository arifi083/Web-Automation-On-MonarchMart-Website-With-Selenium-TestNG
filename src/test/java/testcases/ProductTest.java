package testcases;

import baseclass.BaseClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.*;

import java.io.IOException;

public class ProductTest extends BaseClass {
    public LoginPage loginPage;
    public HomePage homePage;
    public NavbarPage navbarPage;
    public ProductPage productPage;
    public ProductDetailsPage productDetailsPage;
    ;
    public ProductTest() throws IOException {
        super();
    }

    @BeforeMethod
    public void initialization() throws IOException {
        setUp();
        loginPage = new LoginPage();
        homePage = new HomePage();
        navbarPage = new NavbarPage();
        productPage = new ProductPage();
        productDetailsPage = new ProductDetailsPage();

    }

    @Test
    public void searchProduct() throws IOException, InterruptedException {
        homePage =loginPage.login(getEmail(),getPassword());;
        homePage.flashSaleText();
        productPage = navbarPage.navigation();
        productDetailsPage = productPage.productSearching();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
