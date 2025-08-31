package qa_guru_allure;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {

    @Test
    public void testIssueSearch(){
        open("https://github.com/");
        $("[placeholder='Search or jump to...']").click();
        $("[name='query-builder-test']").setValue("eroshenkoam/allure-example").pressEnter();

        $(linkText("eroshenkoam/allure-example")).click();
        $("#pull-requests-tab").click();
        $(byText("#91 opened")).should(Condition.exist);
    }
}
