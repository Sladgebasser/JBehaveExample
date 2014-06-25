Narrative:
In order to goto Rozetka
As a non-user
I want to make sure that delivery costs as expected
		 
Scenario: Delivery with purchase which costs less then 1500.
Given rozetka home page
And category of purchase: phones
And subcategory of purchase: smartphones
And all products of subcategory are shown
And chosen products with max price: 1500
And chosen purchase
And purchase price less then: 1500
When click click-to-buy button
And click checkout button
And enter contact data:
|name|city|phone|
|Test|Киев|0445370222|
And next-step button has been clicked
Then should be shown next delivery price: 35

Scenario: Delivery with purchase which costs more then 1500.
Given rozetka home page
And category of purchase: phones
And subcategory of purchase: smartphones
And all products of subcategory are shown
And chosen products with min price: 1500
And chosen purchase
And purchase price more then: 1500
When click click-to-buy button
And click checkout button
And enter contact data:
|name|city|phone|
|Test|Киев|0445370222|
And next-step button has been clicked
Then should be shown next delivery price: бесплатно

Scenario: Delivery with purchase which costs more then 20000.
Given rozetka home page
And category of purchase: phones
And subcategory of purchase: smartphones
And all products of subcategory are shown
And chosen purchase
And purchase price more then: 20000
When click click-to-buy button
And enter correct quantity of purchase
And click checkout button
And enter contact data:
|name|city|phone|
|Test|Киев|0445370222|
And next-step button has been clicked
Then should be shown next delivery price: бесплатно
And should be free gift

Scenario: Delivery by yourself with purchase which costs more then 1500.
Given rozetka home page
And category of purchase: phones
And subcategory of purchase: smartphones
And all products of subcategory are shown
And chosen products with min price: 1500
And chosen purchase
And purchase price more then: 1500
When click click-to-buy button
And click checkout button
And enter contact data:
|name|city|phone|
|Test|Киев|0445370222|
And next-step button has been clicked
Then should be shown next delivery by yourself price: бесплатно