package org.Sladgebasser.RozetkaExample.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

	private WebDriver driver;

    private By userNameField = By.cssSelector("#reciever_name");
    private By locationSelect = By.cssSelector("#suggest_locality");
    private By locationKyiv = By.xpath("//section[@id='step_contacts']/div/div/div/div[2]/div[2]/div/div/div/ul/li");
    private By phoneNumberField = By.cssSelector("#reciever_phone");
    private By nextStepButton = By.xpath("(//button[@name='next_step'])[2]");
    private By deliverySelection = By.xpath("//div[@id='orders']/div/div/div[2]/div/div[2]/ul/li[2]/a");
    private By deliveryPrice = By.xpath("//div[@id='orders']/div/div/div[2]/div/div[2]/div[2]/ul/li/div/div/div/div");
    private By deliveryByYourselfButton = By.xpath("//label[@name='pickups_5']");
    private By deliveryByYourselfCost = By.xpath("//div[@id='orders']/div/div/div[2]/div/div[2]/div/ul/li[2]/div/div/div/div");
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;	
	}
	
	public void enterUserName(String username) {
		driver.findElement(userNameField ).clear();
		driver.findElement(userNameField ).sendKeys(username);
	}
	
	public void chooseCity(String Location) {
		driver.findElement(locationSelect).click();
		driver.findElement(locationKyiv).click();
	}
	
	public void enterPhone(String phone) {
		driver.findElement(phoneNumberField).clear();
		driver.findElement(phoneNumberField).sendKeys(phone);
	}
	
	public void nextStepButton() {
		driver.findElement(nextStepButton).click();
	}
	
	public boolean isCorrectDeliveryCost(String message) {
		driver.findElement(deliverySelection).click();
		System.out.println(driver.findElement(deliveryPrice).getText());
		return driver.findElement(deliveryPrice).getText().contains(message);
	}

    public boolean isCorrectDeliveryByYourSelfCost(String message) {
        driver.findElement(deliveryByYourselfButton).click();
        System.out.println(driver.findElement(deliveryByYourselfCost).getText());
        return driver.findElement(deliveryByYourselfCost).getText().contains(message);
    }

    public boolean isFreePresent() {
		return false;
	}
}
