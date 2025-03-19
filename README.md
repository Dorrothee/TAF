# ***Selenium WebDriver***

## Project Overview
This project contains tests for the `https://samguk.com.ua` website library using Selenium WebDriver.

## Prerequisites
- Java Development Kit (JDK) installed
- TestNG framework, Selenium WebDriver set up in your project

## Setup Instructions
1. **Add Dependencies**: Selenium WebDriver, TestNG, WebDriverManager.
2. **Navigate to the test directory**.
3. **Run Tests**: Right-click on the desired test to run

## Acceptance Criteria
- The scenarios are linear (no need to implement complex logic for now). 3 scenarios in total.
- Different locator strategies are used for a task.
- Usage of auto-generated locators is avoided.
- WebDriver API is widely used.
- Different methods of waits are used.
- Test scenarios are clear, stable and good structured.
- Each method in test scenario has assertions.
- Page Objects have consistent structure (decomposition of PO is right).
- Test scenarios are clear, stable and good structured.
- There is at least one level of inheritance between pages (Abstract Page exists).
- There is no code duplication at all.
- Inner implementation of PO is hidden from tests.
- Naming and Code Conventions should be followed.

### First Scenario - Add product to wishlist
1. Navigate to the home page.
2. Click categories.
3. Choose a specific category.
4. On the category page choose a specific product.
5. Add product to the wishlist.
6. Verify that the confirmation message has appeared.
7. Navigate to the wishlist page.
8. Check that the product is in the wishlist.

### Second Scenario - Add product (with set quantity) to the cart
1. Navigate to the home page.
2. Search a specific product.
3. Verify that the product is selected.
4. Set quantity of the product.
5. Add product to the cart.
6. Verify cart popup window is displayed with the desired product. 
7. Verify the price of the product.
8. Close the cart popup modal.

### Third Scenario - User registration
1. Navigate to the home page.
2. Click the profile button.
3. Verify that user is on the profile page.
4. Enter login.
5. Enter email.
6. Enter password.
7. Verify all the entered credentials.