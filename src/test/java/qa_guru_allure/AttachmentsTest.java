package qa_guru_allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static io.qameta.allure.Allure.attachment;
import static org.openqa.selenium.By.linkText;

public class AttachmentsTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE = 91;

    @Test
    @DisplayName("Open the Pull Request in repository and find number 91")
    public void testLambdaAttachments(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com/");
            attachment("Source", Objects.requireNonNull(webdriver().driver().source()));
        });

        step("Ищем репозиторий " + REPOSITORY, () -> {
            $("[placeholder='Search or jump to...']").click();
            $("[name='query-builder-test']").setValue(REPOSITORY).pressEnter();
        });

        step("Кликаем по ссылке репозитория " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("Открываем таб пул реквест", () -> {
            $("#pull-requests-tab").click();
        });

        step("Ищем текст opened с номером " + ISSUE, () -> {
            $(byText("#" + ISSUE + " opened")).should(Condition.exist);
        });
    }

    @Test
    @DisplayName("Open the Pull Request in repository and find number 91")
    public void testAnnotatedAttachmentStep(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.takeScreenshot();
    }
}


