package org.Sladgebasser.RozetkaExample.pages;

import static org.junit.Assert.fail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage {

	private WebDriver driver;
	private Integer purchasePrice;

    private By checkoutButton = By.xpath("//button[@id='popup-checkout']");
    private By quantityField = By.xpath("//input[@name='quantity']");
    private By quantityEnterButton = By.xpath("//div[@id='cart-popup']/div/div/div/div[2]/div/div[4]/div/a/img");
    private By price = By.cssSelector("div.uah");
				
	public BasketPage(WebDriver driver, Integer purchasePrice) {
		this.driver = driver;	
		this.purchasePrice = purchasePrice;
	}
	
	public CheckoutPage clickCheckoutButton() {
		driver.findElement(checkoutButton).click();
		return new CheckoutPage(driver);
	}
	
	public void enterCorrectQuantity(Integer quantity) {
		driver.findElement(quantityField).clear();
		driver.findElement(quantityField).sendKeys(quantity.toString());
		driver.findElement(quantityEnterButton).click();
        for (int second = 0;; second++) {
            if (second >= 30) fail("timeout");
            System.out.println(driver.findElement(price).getText());
            System.out.println(this.purchasePrice);
            if (driver.findElement(price).getText().replaceAll(" ", "").trim().contains(this.purchasePrice.toString())) {
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
	}
}
