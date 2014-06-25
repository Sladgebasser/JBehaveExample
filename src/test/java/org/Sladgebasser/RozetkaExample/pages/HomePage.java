package org.Sladgebasser.RozetkaExample.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    private By phones = By.xpath("//td[@id='phones-mp3-gps']/div/a");
    private By loginButton = By.cssSelector("a[name=\"signin\"]");
    private By loginField = By.cssSelector("input[name=\"login\"]");
    private By passwordField = By.cssSelector("input[name=\"password\"]");
    private By logoutButton = By.cssSelector("a[name=\"signout\"]");
    private By submitButton = By.xpath("//button[@type='submit']");

    public HomePage(WebDriver driver) {
        this.driver=driver;
    }

    public void logIn() {
        driver.findElement(loginButton).click();
        driver.findElement(loginField).clear();
        driver.findElement(loginField).sendKeys("fortesting@i.ua");
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys("ForTestingForTesting");
        driver.findElement(submitButton).click();
        driver.findElement(logoutButton);
    }

    public CategoryPage clickCategory(String category) {
        if (category.contains("phones")) driver.findElement(phones).click();
        else {
            System.out.println(category);
            System.out.println("Category not added yet");
        }
        return new CategoryPage(driver);
    }
}
