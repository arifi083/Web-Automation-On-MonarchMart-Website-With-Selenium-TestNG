package testcases;

import baseclass.BaseClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.*;

import java.io.IOException;

public class ProductDetailsTest extends BaseClass {
    public LoginPage loginPage;
    public HomePage homePage;
    public NavbarPage navbarPage;
    public ProductPage productPage;
    public ProductDetailsPage productDetailsPage;
    public ShoppingCartPage shoppingCartPage;
    ;
    public ProductDetailsTest() throws IOException {
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
        shoppingCartPage = new ShoppingCartPage();

    }

    @Test
    public void productAddToCart() throws IOException, InterruptedException {
        homePage =loginPage.login(getEmail(),getPassword());;
        homePage.flashSaleText();
        productPage = navbarPage.navigation();
        productDetailsPage = productPage.productSearching();
        shoppingCartPage = productDetailsPage.clickAddToCart();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
