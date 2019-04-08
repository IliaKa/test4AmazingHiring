package pages;

import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MarketPage {
    public void filterByCpu(String cpu) {
        switch (cpu.toLowerCase()) {
            case "i7":
                $x(".//*[@class = 'LhMupC0dLR']//*[contains(text(),'i7')]").click();
                break;
            case "i5":
                $x(".//*[@class = 'LhMupC0dLR']//*[contains(text(),'i7')]").click();
                $x(".//*[@class = 'LhMupC0dLR']//*[contains(text(),'Xiaomi')]").click();
                $x(".//*[@class = 'LhMupC0dLR']//*[contains(text(),'i5')]").click();
                break;
            default:
                System.out.println("Такая модель не поддерживается");
                break;
        }
    }

    private MarketPage filterByModel(String model) {
        switch (model.toLowerCase()) {
            case "apple":
                $x(".//*[@class = 'LhMupC0dLR']//*[contains(text(),'Apple')]").click();
                $x(".//h1[contains(text(),'Apple')]").waitUntil(Condition.visible, 10000);
                break;
            case "lenovo":
                $x(".//*[@class = 'LhMupC0dLR']//*[contains(text(),'Apple')]").click();
                $x(".//*[@class = 'LhMupC0dLR']//*[contains(text(),'Lenovo')]").click();
                $x(".//h1[contains(text(),'Lenovo')]").waitUntil(Condition.visible, 10000);

                break;
            case "xiaomi":
                $x(".//*[@class = 'LhMupC0dLR']//*[contains(text(),'Lenovo')]").click();
                $x(".//*[@class = 'LhMupC0dLR']//*[contains(text(),'Xiaomi')]").click();
                $x(".//h1[contains(text(),'Xiaomi')]").waitUntil(Condition.visible, 10000);
                break;
            default:
                System.out.println("Такая модель не поддерживается");
                break;
        }
        return this;
    }

    private String getNumberOfItemsAfterFiltration() {
        String[] number = $((".n-search-preciser__results-count")).getText().split(" ");
        return number[1];
    }


    public String getNumbersOf(String model) {
        return filterByModel(model)
                .getNumberOfItemsAfterFiltration();
    }


    public void printInfoAboutAllModels(String appleWithI7, String lenovoWithI7, String xiaomiWithI7, String appleWithI5, String lenovoWithI5, String xiaomiWithI5) {
        System.out.printf("Core i7: %n Apple %s %n Lenovo %s %n Xiaomi %s %n", appleWithI7, lenovoWithI7, xiaomiWithI7);
        System.out.println();
        System.out.printf("Core i5: %n Apple %s %n Lenovo %s %n Xiaomi %s %n", appleWithI5, lenovoWithI5, xiaomiWithI5);
    }

}
