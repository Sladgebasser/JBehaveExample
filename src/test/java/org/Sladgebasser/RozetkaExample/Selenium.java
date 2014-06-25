package org.Sladgebasser.RozetkaExample;

import java.util.concurrent.TimeUnit;
import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.AfterStories;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.fail;

public class Selenium {

    private WebDriver driver;
    private String baseUrl;

    private By deleteButton = By.xpath("//div[@id='cart-popup']/div/div/div/div[2]/div/div/a/img");
    private By openBascetButton = By.xpath("//a[@name='open_cart']");
    private By closeButton = By.xpath("//div[@id='cart-popup']/div/a/img");
    private By waitForText = By.xpath("//div[@id='drop-block']/div/h3");
    private By logoutButton = By.cssSelector("a[name=\"signout\"]");
    private By userButton = By.xpath("//div[@id='user_menu']/div/a");

    public Selenium() {
        baseUrl = "http://rozetka.com.ua";
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @AfterScenario
    public void afterScenario() {
        driver.navigate().to(baseUrl);
        driver.findElement(openBascetButton).click();
        driver.findElement(deleteButton).click();
        for (int second = 0;; second++) {
            if (second >= 30) fail("timeout");
            if (driver.findElement(waitForText).getText().contains("Корзина пуста")) {
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        driver.findElement(closeButton).click();
        if (driver.findElement(userButton).getText().contains("Выход")) {
            driver.findElement(logoutButton).click();
        }
        driver.manage().deleteAllCookies();
    }

    @AfterStories
    public void afterStories() {
        driver.close();
    }

    public WebDriver getSelenium() {
        return driver;
    }
}
