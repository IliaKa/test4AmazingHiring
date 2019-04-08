package pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;


public class YandexPage {


    public YandexPage openYandexPage() {
        open("http://yandex.ru");
        return this;
    }

    public YandexPage goToYandexMarket() {
        $x(".//*[@data-id = 'market']").click();
        return this;
    }

    public void searchItemsOnTheMarketPage(String s) {
        $(By.id("header-search")).val(s).pressEnter();
    }

}


