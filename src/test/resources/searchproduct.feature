Feature: to Test user can search an item

Scenario: TC01_Verify User can Login and search an Item
	Given User can login into Amazon Application
	And user should search an item successfully
	Then user should land on Search products page
	When user clicks on any product
	Then user should land on Product landing page
	
Scenario: TC02_Verify User can search an item in Search Results Page
	Given User can login into Amazon Application
	And user should search an item successfully
	Then user should land on Search products page
	And user should search an item successfully
	Then user should land on Search products page
	When user clicks on any product
	Then user should land on Product landing page