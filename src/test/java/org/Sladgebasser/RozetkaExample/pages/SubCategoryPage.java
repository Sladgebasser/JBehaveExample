package org.Sladgebasser.RozetkaExample.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubCategoryPage {

    private WebDriver driver;

    private By allProductsButton = By.xpath("//div[@id='head_banner_container']/div[4]/div/div/div[2]/div[3]/ul/li/ul/li/a");

    public SubCategoryPage(WebDriver driver) {
        this.driver=driver;
    }

    public PurchaseListPage clickPurchaseListButton(){
        driver.findElement(allProductsButton).click();
        return new PurchaseListPage(driver);
    }
}
