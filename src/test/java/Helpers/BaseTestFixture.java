package Helpers;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseTestFixture extends AppManager
{
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    @BeforeEach
    public void setUp()
    {
        screenshotIndex = 0;

        driver = GetWebDriver();

        wait = GetWebDriverWait();

        driver.get(AppManager.baseURL);
    }

    @AfterEach
    public void cleanUp(){
        driver.manage().deleteAllCookies();
    }

    @AfterAll
    public static void tearDown(){
        driver.close();
    }
}
