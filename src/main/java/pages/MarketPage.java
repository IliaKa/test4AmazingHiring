package pages;

import com.codeborne.selenide.Condition;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MarketPage {
    String stuffName = ".//*[@class = 'LhMupC0dLR']//*[contains(text(),'%s')]";
    String header = ".//h1[contains(text(),'%s')]";


    public String filterByCpu(String cpu) {
                $x(String.format(stuffName, cpu.toLowerCase())).click();
                return getNameOfItem(cpu);
    }

    private MarketPage filterByModel(String model) {
        $x(String.format(stuffName, model)).click();
        $x(String.format(header, model)).waitUntil(Condition.visible, 10000);
        return this;
    }

    private String getNumberOfItemsAfterFiltration() {
        String[] number = $((".n-search-preciser__results-count")).getText().split(" ");
        return number[1];
    }

    private String getNameOfItem(String name) {
        return $x((String.format(stuffName, name))).getText();

    }

    public void clearField(String model) {
        $x(String.format(stuffName, model)).click();
    }


    public String getNumbersOf(String model) {

        String res =  filterByModel(model)
                .getNumberOfItemsAfterFiltration();
                clearField(model);
        return res;
    }

    public void printInfoAboutAllModels(ArrayList<String> result) {
        result.forEach(System.out::println);
        }
}
