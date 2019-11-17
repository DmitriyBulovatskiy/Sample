package Pages.BasePage;

import Helpers.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.image.ImageObserver;

public abstract class BaseLoginPage extends BasePage
{
    protected By EmailEntry = By.name("session[username_or_email]");
    protected By PasswordEntry = By.cssSelector("[name='session[password]']");
    protected By SubmitBtn = By.xpath("//input[@type='submit']");

    //Mob/Tab
    protected By EmailEntryTM = By.cssSelector(".js-username-field.email-input.js-initial-focus");
    protected By PasswordEntryTM = By.cssSelector(".js-password-field");
    protected By GoToLoginButtonTM = By.cssSelector("a[href^='/login']");
    protected By SumbitBtnTM  = By.cssSelector(".submit.EdgeButton.EdgeButton--primary.EdgeButtom--medium");


    public BaseLoginPage(WebDriver driver) {
        super(driver);
    }
}
