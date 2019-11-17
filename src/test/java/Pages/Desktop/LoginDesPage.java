package Pages.Desktop;

import Pages.BasePage.BaseLoginPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class LoginDesPage extends BaseLoginPage {
    public LoginDesPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public LoginDesPage EnterEmail(String text)
    {
        Enter(EmailEntry, text);
        TakeScreenshot(driver, "EnterEmail");

        return this;
    }

    @Step
    public LoginDesPage EnterPassword(String text)
    {
        Enter(PasswordEntry, text);
        TakeScreenshot(driver, "EnterPassword");

        return this;
    }

    @Step
    public LoginDesPage TapSubmit()
    {
        Tap(SubmitBtn);
        TakeScreenshot(driver, "TapSubmit");

        return this;
    }
}
