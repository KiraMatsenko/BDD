package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ReplenishObject {
    private SelenideElement whereFrom = $("input[placeholder='0000 0000 0000 0000']");

    private SelenideElement amount = $("[type=text]");
    private SelenideElement replenishButton = $("button[data-test-id='action-transfer']");

    public ReplenishObject() {
        amount.shouldBe(visible);
    }

    public DashboardObject replenishButton() { //подтверждаем пополнение
        replenishButton.click();
        return new DashboardObject();
    }

    public void inputSum(String sum) { // вводим сумму пополнения
        amount.setValue(sum);
    }

    public void inputCard(String cardNumber) { // вводим номер карты с которой переводим средства
        whereFrom.setValue(cardNumber);
    }
}
