package Pages.Mobile;

import Pages.BasePage.BaseLoginPage;
import Pages.Desktop.LoginDesPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class LoginMobPage extends BaseLoginPage {
    public LoginMobPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public LoginMobPage GoToLogin()
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
    public LoginMobPage EnterEmail(String text)
    {
        Enter(EmailEntryTM, text);
        TakeScreenshot(driver, "EnterEmail");

        return this;
    }

    @Step
    public LoginMobPage EnterPassword(String text)
    {
        Enter(PasswordEntryTM, text);
        TakeScreenshot(driver, "EnterPassword");

        return this;
    }

    @Step
    public LoginMobPage TapSubmit()
    {
        Tap(SumbitBtnTM);
        TakeScreenshot(driver, "TapSubmit");

        return this;
    }
}
