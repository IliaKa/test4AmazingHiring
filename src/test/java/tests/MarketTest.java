package tests;


import org.testng.annotations.Test;
import pages.MarketPage;
import pages.YandexPage;


public class MarketTest extends AbstractBrowserTest {

    @Test
    public void countNotebookModels() {
        YandexPage yp = new YandexPage();
        MarketPage mp = new MarketPage();


        yp.openYandexPage()
                  .goToYandexMarket()
                  .searchItemsOnTheMarketPage("ноутбуки");

        mp.filterByCpu("i7");
        String appleWithI7 = mp.getNumbersOf("Apple");
        String lenovoWithI7 = mp.getNumbersOf("Lenovo");
        String xiaomiWithI7 = mp.getNumbersOf("Xiaomi");

        mp.filterByCpu("i5");
        String appleWithI5 = mp.getNumbersOf("Apple");
        String lenovoWithI5 = mp.getNumbersOf("Lenovo");
        String xiaomiWithI5 = mp.getNumbersOf("Xiaomi");

        mp.printInfoAboutAllModels(appleWithI7, lenovoWithI7, xiaomiWithI7, appleWithI5, lenovoWithI5, xiaomiWithI5);
    }
}
