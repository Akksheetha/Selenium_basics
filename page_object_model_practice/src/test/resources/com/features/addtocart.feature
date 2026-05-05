Feature: Adding a product in the  DemoBlaze site

Background:
Given user is on Product page

 @AddingAvailableProduct
 Scenario: Adding available product to the cart
 
 When user tries to add a product to the cart
 And clicks add to cart button
 Then the product should be added to the cart successfully
 
 @AddingUnAvailableProduct
 Scenario: Adding unavailable product to the cart
 
 When user tries to add a product to the cart that is not available
 Then ththe add to cart button should not be visible
 
 
 @ProductOutOfStock
 Scenario: Adding product to the cart which is out of stock
 
 When user tries to add a product to the cart that is out of stock
 Then ththe add to cart button should not be visible