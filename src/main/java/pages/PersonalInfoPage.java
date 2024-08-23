package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;;

import static com.codeborne.selenide.Selenide.*;

public class PersonalInfoPage {

    private SelenideElement tabPersonalInfo = $(By.xpath("/html/body/c-wiz/div/div[2]/div/c-wiz/c-wiz/div/div[1]/div[3]/c-wiz/nav/ul/li[2]/a"));
    private SelenideElement menuGender = $("a[data-rid=\"206\"]");

    @Step("Go to Personal info page by tab from navigation menu")
    public void openTabPersonalInfo (){
        tabPersonalInfo.click();
    }

    @Step("Go to menu Gender")
    public void openMenuGender(){
        menuGender.click();
    }

    @Step("Choose the new gender")
    public void chooseNewGender (){
        ElementsCollection ec = $$("input[type=\"radio\"]");
        String preCondition = $$("input[type=\"radio\"]").filter(Condition.checked).first().parent().parent().getText();
        $$("input[type=\"radio\"]").excludeWith(Condition.attribute("checked")).first().click();
        String postCondition = $$("input[type=\"radio\"]").filter(Condition.checked).first().parent().parent().getText();

        if (preCondition == postCondition){
            throw new NullPointerException("New gender NOT selected !!!");
        }
    }
}
