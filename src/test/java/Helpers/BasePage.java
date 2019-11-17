package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BasePage extends AppManager
{
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    public BasePage(WebDriver driver)
    {
        BasePage.driver = driver;
        wait = new WebDriverWait(BasePage.driver, 120);
    }



    protected static WebElement Wait(final By by)
    {
        FluentWait<WebDriver> waitImpl = new WebDriverWait(driver, 10);

        return  waitImpl.until((ExpectedCondition<WebElement>) d -> {
            List<WebElement> elements = d.findElements(by);

            return elements.isEmpty() ? null : elements.get(0);
        });
    }

    protected void Tap(By element)
    {
        Wait(element).click();
    }

    protected void Enter(By element, String text)
    {
        Wait(element).sendKeys(text);
    }
}
