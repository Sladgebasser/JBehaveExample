package org.Sladgebasser.RozetkaExample.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PurchasePage {

	private WebDriver driver;
	private Integer purchasePrice;
	private int givenPrice;
	private int success;
	private Integer count=1;
	private Integer price;

    private By priceLocator = By.cssSelector("div.pp-uah > span");
    private By buyButton = By.xpath("//button[@name='topurchases']");

	public PurchasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public int checkPrice(String givenPrice, boolean compare) {
        purchasePrice = Integer.parseInt(driver.findElement(priceLocator).getText().replaceAll(" ", "").trim());
        this.givenPrice = Integer.parseInt(givenPrice);
        if (compare) {
            System.out.println("Price is " + purchasePrice + " Price have to be less then: " + this.givenPrice);
            if (purchasePrice > this.givenPrice) {
                System.out.println("You choose too expensive purchase so result can be invalid");
            } else {
                System.out.println("Good choise");
            }
            return 1;
        }
        else {
            price=purchasePrice;
            System.out.println("Price is "+purchasePrice+" Price have to be more then: "+this.givenPrice);
            while (true) {
                System.out.println("Current price: "+price);
                if (price<this.givenPrice) {
                    System.out.println("You choose too cheep purchase, ");
                    success = price-this.givenPrice;
                    if (success<0) {
                        price+=purchasePrice;
                        count++;
                    }
                }
                else {
                    break;
                }
            }
            System.out.println("Number of iterations: "+count);
            System.out.println("Good choise");
            return count;
        }
	}
	
	public BasketPage clickBuyButton() {
        driver.findElement(buyButton).click();
		return new BasketPage(driver, price);
	}
}
