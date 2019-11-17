package Tests.Mobile;

import Helpers.BaseTestFixture;
import Helpers.Enums;
import Pages.Mobile.LoginMobPage;
import org.junit.jupiter.api.Test;

public class LoginMobTest extends BaseTestFixture {
    @Test
    public void LoginMob()
    {
        testName = new Object(){}.getClass().getEnclosingMethod().getName();

        new LoginMobPage(driver)
                .GoToLogin()
                .EnterEmail("0000@gmail.com")
                .EnterPassword("123123")
                .TapSubmit();
    }
}
