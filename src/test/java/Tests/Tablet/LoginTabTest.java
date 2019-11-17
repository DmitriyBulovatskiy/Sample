package Tests.Tablet;

import Helpers.BaseTestFixture;
import Pages.Tablet.LoginTabPage;
import org.junit.jupiter.api.Test;

public class LoginTabTest extends BaseTestFixture {
    @Test
    public void LoginTab()
    {
        testName = new Object(){}.getClass().getEnclosingMethod().getName();


        new LoginTabPage(driver)
                .GoToLogin()
                .EnterEmail("0000@gmail.com")
                .EnterPassword("123123")
                .TapSubmit();
    }



}
