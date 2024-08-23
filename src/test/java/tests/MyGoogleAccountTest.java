package tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import pages.PeopleSharingPage;
import pages.PersonalInfoPage;
import pages.SecurityPage;
import pages.SignInPage;
import utils.SetupAndTeardown;
import utils.Utils;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.*;


public class MyGoogleAccountTest extends SetupAndTeardown {

    Utils utils = new Utils();

    @Severity(SeverityLevel.MINOR)
    @Description("Personal info. Choose the new gender")
    @Story("Personal info")
    @Test(enabled = true, description = "Personal info. Choose the new gender")
    void chooseNewGender() throws FileNotFoundException {

        open(Configuration.baseUrl);
        new SignInPage()
            .signInWithValidUser(utils.getDataFromConfig("EMAIL"), utils.getDataFromConfig("PASSWORD"));

        PersonalInfoPage pi = new PersonalInfoPage();
        pi.openTabPersonalInfo();
        pi.openMenuGender();
        pi.chooseNewGender();
    }

    @Severity(SeverityLevel.MINOR)
    @Description("Security. Сheck the location where the account was last authorized")
    @Story("Security")
    @Test(enabled = true, description = "Security. Review security activity")
    void RecentSecurityActivity() throws FileNotFoundException {

        open(Configuration.baseUrl);
        new SignInPage()
                .signInWithValidUser(utils.getDataFromConfig("EMAIL"), utils.getDataFromConfig("PASSWORD"));

        SecurityPage sp = new SecurityPage();
        sp.openTabSecurity();
        sp.openRecentSecurityActivityList();
        sp.openActivityDetails();
        sp.checkInfoAboutDevice(utils.getDataFromConfig("COUNTRY"));
    }

    @Severity(SeverityLevel.MINOR)
    @Description("People & Exchange. Check the display Contacts page")
    @Story("People & Exchange")
    @Test(enabled = true, description = "People & Exchange. Check the display Contacts page")
    void OpenContactsPage() throws FileNotFoundException, InterruptedException {

        open(Configuration.baseUrl);
        new SignInPage()
                .signInWithValidUser(utils.getDataFromConfig("EMAIL"), utils.getDataFromConfig("PASSWORD"));

        PeopleSharingPage psp = new PeopleSharingPage();
        psp.openTabPeopleSharingPage();
        psp.openContactsPage();
    }

}
