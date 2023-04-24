package testcases;

import baseclass.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.IndexPage;

import java.io.IOException;

public class IndexTest extends BaseClass {
    public IndexPage indexPage;
    public IndexTest() throws IOException {
        super();
    }

    @BeforeMethod
    public void initialization() throws IOException {
        setUp();
    }

    @Test
    public void verifyLogo() throws IOException {
        indexPage = new IndexPage();
        boolean result = indexPage.validateLogo();
        System.out.println("arif");
        Assert.assertTrue(result);
    }

    @Test
    public void verifyTitle() throws IOException {
        indexPage = new IndexPage();
        String getTitle = indexPage.verifyTitle();
        Assert.assertEquals(getTitle,"Monarch Mart: Changing Online Shopping Experience in Bangladesh");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
