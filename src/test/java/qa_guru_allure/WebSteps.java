package qa_guru_allure;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com/");
    }

    @Step("Ищем репозиторий {repo}")
    public void searchForRepository(String repo){
        $("[placeholder='Search or jump to...']").click();
        $("[name='query-builder-test']").setValue(repo).pressEnter();
    }

    @Step("Кликаем по ссылке репозитория {repo}")
    public void clickOnRepositoryLink(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Открываем таб пул реквест")
    public void openPullRequestTab() {
        $("#pull-requests-tab").click();
    }

    @Step("Ищем текст opened с номером {issue}")
    public void shouldSeeIssueWithNumber(int issue){
        $(byText("#" + issue + " opened")).should(Condition.exist);
    }

    }