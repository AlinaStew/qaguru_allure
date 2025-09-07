package qa_guru_allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE = 91;

    @Test
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("LivanovaAS")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://testing.github.com")
    @DisplayName("Создание Issue для авторизованного пользователя")
    public void testStaticLabels(){

    }

    @Test
    public void testDynamicLabels(){

    }
}


