package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByAttribute;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class SecurityPage {

    private SelenideElement tabSecurityPage = $(".HJOYVi11");
    private SelenideElement openRecentSecurityActivityList = $(By.linkText("Recent security activity"));
    private SelenideElement openActivityDetails = $(By.partialLinkText("New"));
    private SelenideElement formProfile = $(new ByAttribute("aria-live", "polite"));

    @Step("Go to Security page by tab from navigation menu")
    public void openTabSecurity (){
        tabSecurityPage.click();
    }

    @Step("Open Recent security activity list")
    public void openRecentSecurityActivityList(){
        openRecentSecurityActivityList.click();
    }

    @Step("Open Activity Details")
    public void openActivityDetails(){
        openActivityDetails.click();
    }

    @Step("Check information about device")
    public void checkInfoAboutDevice(String country){
        formProfile.shouldHave(Condition.text(country));
    }

}
