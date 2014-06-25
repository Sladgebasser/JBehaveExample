package org.Sladgebasser.RozetkaExample.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PurchaseListPage {

    private WebDriver driver;

    private By maxPriceField = By.id("price[max]");
    private By minPriceField = By.id("price[min]");
    private By submitButton = By.id("submitprice");
    private By firstItem = By.xpath("//div[@id='block_with_goods']/div/div/div/div/div/div/div[3]/a");

    public PurchaseListPage(WebDriver driver) {
        this.driver=driver;
    }

    public void selectPriceParams(String Price, boolean min) {
        if (min) driver.findElement(minPriceField).sendKeys(Price);
        else driver.findElement(maxPriceField).sendKeys(Price);
        driver.findElement(submitButton).click();
    }

    public PurchasePage getPurchase() {
        driver.findElement(firstItem).click();
        return new PurchasePage(driver);
    }
}
