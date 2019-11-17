package Helpers;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static Helpers.Enums.Browsers.*;

public abstract class AppManager
{
    private static Enums.Browsers currentBrowserForTest;
    public static Enums.Platforms currentPlatformForTest;
    private static String currentBrowserVersion;
    protected static int screenshotIndex;
    public static String testName;

    @Attachment
    public static byte[] TakeScreenshot(WebDriver driver, String screenshotName)
    {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String projectPath = System.getProperty("user.dir");
        try
        {
            FileUtils.copyFile(scrFile,
                    new File(projectPath + "/target/allure-results/screenshot/" +
                            currentPlatformForTest + "/" +
                            currentBrowserForTest + "-" + currentBrowserVersion + "/" +
                            testName + "/" +
                            screenshotIndex + "-" + screenshotName + ".png"),
                    true);
            screenshotIndex++;
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        System.out.println("TakeScreenshot - " + screenshotName);
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    private static WebDriver driver;
    private static WebDriverWait wait;
    public final static String baseURL = "https://twitter.com/";

    public static WebDriverWait GetWebDriverWait()
    {
        if(wait == null)
            InitWebDriverWait();

        return wait;
    }

    public static void InitWebDriverWait()
    {
        wait = new WebDriverWait(driver, 120);
    }

    public static WebDriver GetWebDriver()
    {
        if(driver == null)
            InitWebDriver();

        return driver;
    }

    public static void InitWebDriver()
    {

        currentBrowserForTest = GoogleChrome;
        currentPlatformForTest = Enums.Platforms.Mobile;
        currentBrowserVersion = "76.0";

        DesiredCapabilities browser = new DesiredCapabilities();
        switch (currentBrowserForTest)
        {
            case FireFox:
                browser.setBrowserName("firefox");
                browser.setVersion("currentBrowserVersion");
                break;
            case GoogleChrome:
                browser.setBrowserName("chrome");
                browser.setVersion(currentBrowserVersion);

                ChromeOptions options = new ChromeOptions();

                options.addArguments("--use-fake-ui-for-media-stream");
                options.addArguments("--disable-user-media-security");
                options.addArguments("--allow-running-insecure-content");
                options.addArguments("--use-fake-device-for-media-stream");

                browser.setCapability(ChromeOptions.CAPABILITY, options);
                break;
            case Opera:
                browser.setBrowserName("opera");
                browser.setVersion(currentBrowserVersion);
                browser.setCapability("operaOptions", new HashMap<String, String>() {{
                    put("binary", "/usr/bin/opera");
                }});
                break;
            default:
                throw new RuntimeException("You must set currentBrowserForTest before using the driver");
        }
        browser.setCapability("enableVNC", true);
        browser.setCapability("enableLog", true);
        browser.setCapability("enableVideo", false);

        try {
            driver = new RemoteWebDriver(new URL(
                    "http://localhost:4444/wd/hub"
            ), browser);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());

        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

        switch (currentPlatformForTest)
        {
            case Desktop:
                driver.manage().window().setSize(new Dimension(1980, 1080));
                break;
            case Tablet:
                driver.manage().window().setSize(new Dimension(800, 800));
                break;
            case Mobile:
                driver.manage().window().setSize(new Dimension(500, 800));
                break;
        }

        System.out.println("InitWebDriver Done");
    }

}
