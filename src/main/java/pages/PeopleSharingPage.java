package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByAttribute;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlStartingWith;



public class PeopleSharingPage {

    private SelenideElement tabPeopleSharingPage = $(".HJOYVi12");
    private SelenideElement openContactsPage = $(new ByAttribute("aria-label", "Contacts"));

    @Step("Go to People & Sharing page by tab from navigation menu")
    public void openTabPeopleSharingPage (){
        tabPeopleSharingPage.click();
    }

    @Step("Go to Contacts page")
    public void openContactsPage(){
        openContactsPage.click();
        webdriver().shouldHave(urlStartingWith("https://contacts.google.com/"));
    }
}
