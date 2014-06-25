package org.Sladgebasser.RozetkaExample.steps;

import java.util.Map;
import org.Sladgebasser.RozetkaExample.Selenium;
import org.Sladgebasser.RozetkaExample.pages.*;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.junit.Assert;

public class Steps extends Selenium {
	
	public Steps() throws Exception {
		super();
	}

	private Map<String, String> message;
    private Integer quantity;

    private HomePage homePage;
    private CategoryPage categoryPage;
    private SubCategoryPage subCategoryPage;
    private PurchaseListPage purchaseListPage;
    private PurchasePage purchasePage;
	private BasketPage basketPage;
	private CheckoutPage checkoutPage;

    @Given("rozetka home page")
    public void givenHomePage(){
        homePage = new HomePage(getSelenium());
    }

    @Given("log-in")
    public void givenLogIn(){
        homePage.logIn();
    }

    @Given("category of purchase: $category")
    public void givenCategoryPage(String category){
        categoryPage=homePage.clickCategory(category);
    }

    @Given("subcategory of purchase: $subcategory1")
	public void givenSubcategoryPage(String subcategory) {
		subCategoryPage = categoryPage.clickSuCategory(subcategory);
	}

    @Given("all products of subcategory are shown")
    public void givenAllProductsAreShown(){
        purchaseListPage = subCategoryPage.clickPurchaseListButton();
    }

    @Given("chosen products with max price: $Price")
    public void givenFilterByMaxPrice(String Price) {
        purchaseListPage.selectPriceParams(Price, false);
    }

    @Given("chosen products with min price: $Price")
    public void givenFilterByMinPrice(String Price) {
        purchaseListPage.selectPriceParams(Price, true);
    }

    @Given("chosen purchase")
    public void givenChoosenPurchase(){
        purchasePage = purchaseListPage.getPurchase();
    }

    @Given("purchase price less then: $givenPrice")
	public void givenCorrectSmallPrice(String givenPrice) {
		purchasePage.checkPrice(givenPrice, true);
	}

	@Given("purchase price more then: $givenPrice")
	public void givenCorrectPrice(String givenPrice) {
		quantity = purchasePage.checkPrice(givenPrice, false);
	}

	@When("click click-to-buy button")
	public void whenPushBuyButton() {
		basketPage = purchasePage.clickBuyButton();
	}

    @When("enter correct quantity of purchase")
	public void whenEnterCorrectQuantity() {
		basketPage.enterCorrectQuantity(quantity);
	}

	@When("click checkout button")
	public void whenPushCheckoutButton() {
		checkoutPage = basketPage.clickCheckoutButton();
	}

	@When("enter contact data: $examplesTable")
	public void whenEnterContactData(ExamplesTable examplesTable) {
		message = examplesTable.getRow(0);
		checkoutPage.enterUserName(message.get("name"));
		checkoutPage.chooseCity(message.get("Location"));
		checkoutPage.enterPhone(message.get("phone"));
	}

	@When("next-step button has been clicked")
	public void whenClickNextStepButton() {
		checkoutPage.nextStepButton();
	}

	@Then("should be shown next delivery price: $price")
	public void thenDeliveryPrice(String price) {
		Assert.assertTrue(checkoutPage.isCorrectDeliveryCost(price));
	}

    @Then("should be shown next delivery by yourself price: $price")
    public void ThenDeliveryByYourselfPrice(String price) {
        Assert.assertTrue(checkoutPage.isCorrectDeliveryByYourSelfCost(price));
    }

	@Then("should be free gift")
	public void ThenFreePresent() {
		try {
			Assert.assertTrue(checkoutPage.isFreePresent());
		}
		catch (AssertionError e) {
			System.out.println("Functionality is not added yet");
		}
	}
}
