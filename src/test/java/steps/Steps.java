package steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;
import page.DashboardObject;
import page.LoginObject;
import page.ReplenishObject;
import page.VerificationPage;

import static com.codeborne.selenide.Selenide.$;

public class Steps {
    private static LoginObject loginObject;
    private static DashboardObject dashboardObject;
    private static VerificationPage verificationPage;
    private static ReplenishObject replenishObject;

    @Пусть("откртыта страница с формой авторизации {string}")
    public void openAuthPage(String url) {
        Configuration.holdBrowserOpen = true;
        loginObject = Selenide.open(url, LoginObject.class);
    }

    @Когда("пользователь залогинен с именем {string} и паролем {string}")
    public void loginWithNameAndPassword(String login,String password) {
        verificationPage = loginObject.validLoginWCucumber(login, password);
    }

    @И("пользователь вводит проверочный код из смс {string}")
    public void setValidCode(String verificationCode) {
        dashboardObject = verificationPage.validVerifyWCucumber(verificationCode);
    }

    @Когда("пользователь переводит {string} рублей с карты с номером {string} на свою 1 карту с главной страницы")
    public void replenishFromCard1ToCard2(String sum, String cardNumber) {
        dashboardObject = dashboardObject.selectReplenish1().inputSum(sum).inputCard(cardNumber).replenish();
    }

    @Тогда("баланс его 1 карты из списка на главной странице должен стать {string} рублей.")
    public void checkBalanceAfterReplenish(String balance) {
        Assertions.assertEquals(Integer.parseInt(balance), dashboardObject.getFirstCardBalance());
    }
}