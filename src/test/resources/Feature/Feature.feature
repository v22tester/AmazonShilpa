Feature: validate shoppig cart
Scenario: check shopping cart is empty
Given user should be on amazon home page
When user click on shopping cart
Then cart should be empty