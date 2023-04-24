package testcases;

import baseclass.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.*;

import java.io.IOException;

public class ShoppingCartTest extends BaseClass {

    public LoginPage loginPage;
    public HomePage homePage;
    public NavbarPage navbarPage;
    public ProductPage productPage;
    public ProductDetailsPage productDetailsPage;
    public ShoppingCartPage shoppingCartPage;
    public OrderPage orderPage;
    ;
    public ShoppingCartTest() throws IOException {
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
        orderPage = new OrderPage();

    }

    @Test
    public void orderProduct() throws IOException, InterruptedException {
        homePage =loginPage.login(getEmail(),getPassword());;
        homePage.flashSaleText();
        productPage = navbarPage.navigation();
        productDetailsPage = productPage.productSearching();
        String bookDetailsPageProductName = productDetailsPage.verifyProductName();
        shoppingCartPage = productDetailsPage.clickCartIcon();
        String shoppingCartPageProductName = shoppingCartPage.verifyProductName();
        Assert.assertEquals(bookDetailsPageProductName,shoppingCartPageProductName);
        orderPage = shoppingCartPage.addOrderProduct();


    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
