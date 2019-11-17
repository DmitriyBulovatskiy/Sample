package Pages.Tablet;

import Pages.BasePage.BaseLoginPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginTabPage extends BaseLoginPage {
    public LoginTabPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public LoginTabPage GoToLogin()
    {
        Tap(GoToLoginButtonTM);
        TakeScreenshot(driver, "GoToLogin");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    @Step
    public LoginTabPage EnterEmail(String text)
    {
        Enter(EmailEntryTM, text);
        TakeScreenshot(driver, "EnterEmail");

        return this;
    }

    @Step
    public LoginTabPage EnterPassword(String text)
    {
        Enter(PasswordEntryTM, text);
        TakeScreenshot(driver, "EnterPassword");

        return this;
    }

    @Step
    public LoginTabPage TapSubmit()
    {
        Tap(SumbitBtnTM);
        TakeScreenshot(driver, "TapSubmit");

        return this;
    }

}
