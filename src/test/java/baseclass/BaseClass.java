package baseclass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import utilities.TimeOut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    protected static WebDriver driver;
    private Properties properties;

    public BaseClass() throws IOException {
        try {
            properties = new Properties();
            String filePath = System.getProperty("user.dir") + "/src/test/resources/config.properties";
            FileInputStream inputStream = null;
            inputStream = new FileInputStream(filePath);
            properties.load(inputStream);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }


    public void setUp() {
        String browserName=properties.getProperty("browser");
        if(browserName.equals("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if(browserName.equals("Firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else if (browserName.equals("IE")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }

        driver.manage().window().maximize();
        //get url
        driver.get(properties.getProperty("baseUrl"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TimeOut.PAGE_WAIT_TIME));

    }

    public String getFirstName(){return properties.getProperty("firstName");}
    public String getLastName(){return properties.getProperty("lastName");}
    public String getPhoneNumber(){return properties.getProperty("phoneNumber");}
    public String getEmail(){return properties.getProperty("email");}
    public String getPassword(){return properties.getProperty("password");}
    public String getConfirmPassword(){return properties.getProperty("confirmPassword");}
    public String getOrderNote(){return properties.getProperty("orderNote");}





}
