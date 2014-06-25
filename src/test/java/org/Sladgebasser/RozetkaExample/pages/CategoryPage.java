package org.Sladgebasser.RozetkaExample.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryPage {

    private WebDriver driver;

    private By smartphones = By.xpath("//div[@id='head_banner_container']/div[3]/div/div/div[2]/div[3]/ul/li/ul/li[2]/a");

    public CategoryPage(WebDriver driver) {
        this.driver=driver;
    }

    public SubCategoryPage clickSuCategory(String subcategory) {
        if (subcategory.contains("smartphones")) driver.findElement(smartphones).click();
        else {
            System.out.println(subcategory);
            System.out.println("subcategory not added yet");
        }
        return new SubCategoryPage(driver);
    }
}
