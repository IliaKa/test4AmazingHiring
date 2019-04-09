package tests;


import org.testng.annotations.Test;
import pages.MarketPage;
import pages.YandexPage;

import java.util.ArrayList;


public class MarketTest extends AbstractBrowserTest {

    @Test
    public void countNotebookModels() {
        YandexPage yp = new YandexPage();
        MarketPage mp = new MarketPage();
        ArrayList<String> result = new ArrayList<>();

        yp.openYandexPage()
                  .goToYandexMarket()
                  .searchItemsOnTheMarketPage("ноутбуки");

        result.add(mp.filterByCpu("i7"));
        result.add("Apple " + mp.getNumbersOf("Apple"));
        result.add("Lenovo " + mp.getNumbersOf("Lenovo"));
        result.add("Xiaomi " + mp.getNumbersOf("Xiaomi"));

        mp.clearField("i7");
        result.add("");

        result.add(mp.filterByCpu("i5"));
        result.add("Apple " + mp.getNumbersOf("Apple"));
        result.add("Lenovo " + mp.getNumbersOf("Lenovo"));
        result.add("Xiaomi " + mp.getNumbersOf("Xiaomi"));

        result.forEach(System.out::println);
    }
}
