package Tests.Desktop;

import Helpers.*;
import Pages.Desktop.LoginDesPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Dimension;


public class LoginDesTest extends BaseTestFixture
{

    @Test

    public void Login()
    {
        testName = new Object(){}.getClass().getEnclosingMethod().getName();

        new LoginDesPage(driver)
                .EnterEmail("0000@gmail.com")
                .EnterPassword("123123")
                .TapSubmit();
    }
}
