package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByAttribute;
import io.qameta.allure.Step;
import utils.Utils;

import java.io.FileNotFoundException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;


public class SignInPage {
    private SelenideElement buttonGoToGoogleAccount = $(".h-c-header__cta > ul > li.h-c-header__cta-li.h-c-header__cta-li--primary");
    private SelenideElement fieldEmail = $("#identifierId");
    private SelenideElement buttonNextOnPasswordForm = $("#identifierNext");
    private SelenideElement fieldPassword =  $(new ByAttribute("autocomplete", "current-password"));
    private SelenideElement buttonNextOnHomePage = $("#passwordNext");

    public void buttonGoToGoogleAccount(){
        this.buttonGoToGoogleAccount.click();
    }

    public void enterEmail(String email){
        this.fieldEmail.setValue(email);
    }

    public void goToPasswordForm(){
        this.buttonNextOnPasswordForm.click();
    }

    public void enterPassword(String password) {
        this.fieldPassword.setValue(password);
    }

    public void goToHomePage(){
        this.buttonNextOnHomePage.click();
    }

    @Step("SignIn")
    public void signInWithValidUser(String email, String password) throws FileNotFoundException {
        buttonGoToGoogleAccount();
        enterEmail(email);
        goToPasswordForm();
        enterPassword(password);
        goToHomePage();

        Utils utils = new Utils();
        StringBuilder str = new StringBuilder("Welcome,");
        str.append(" "+utils.getDataFromConfig("FIRST_NAME"));
        str.append(" "+utils.getDataFromConfig("LAST_NAME"));
        $("header h1").scrollIntoView(true).shouldHave(text(str.toString()));
    }
}
