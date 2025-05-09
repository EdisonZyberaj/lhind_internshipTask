# Magento E-commerce Test Automation Framework

## Overview

This project is a test automation framework built with Selenium WebDriver and TestNG for testing the Magento e-commerce platform. The framework implements the Page Object Model (POM) design pattern to create a maintainable and scalable test suite.

## Project Structure

```
src/
├── main/
│   └── java/
│       └── com/
│           └── pages/
│               ├── BasePage.java
│               ├── HomePage.java
│               ├── LoginPage.java
│               ├── ProductPage.java
│               └── RegisterPage.java
└── test/
    └── java/
        └── com/
            └── test/
                ├── AddToCartTest.java
                ├── LoginTest.java
                └── RegistrationTest.java
```

## Page Object Model (POM)

The framework uses the Page Object Model design pattern, which provides the following benefits:

- **Code reusability**: Each page is represented by its own class, making the code more modular and reusable
- **Maintainability**: Separate classes for each page make it easier to update the code when UI changes
- **Readability**: Test cases are cleaner and easier to understand as UI interactions are encapsulated within page classes

### Page Classes

The framework includes the following page classes:

#### BasePage

A base class that contains common methods used across all page objects:

- `type()`: Enter text into an input field
- `click()`: Click on an element
- `getText()`: Get text from an element
- `find()`: Find a WebElement by locator

#### HomePage

Represents the Magento home page with methods for:

- `searchProduct()`: Search for a product
- `selectFirstProductFromResults()`: Select the first product from search results
- `navigateToLoginPage()`: Navigate to the login page
- `navigateToRegisterPage()`: Navigate to the registration page

#### LoginPage

Represents the login page with methods for:

- `enterEmail()`: Enter email address
- `enterPassword()`: Enter password
- `clickSignInButton()`: Click the sign-in button
- `login()`: Combined method to perform a complete login
- `isLoginSuccessful()`: Check if login was successful

#### ProductPage

Represents a product details page with methods for:

- `selectSize()`: Select a product size
- `selectColor()`: Select a product color
- `clickAddToCart()`: Add the product to cart
- `getSuccessMessage()`: Get the success message after adding to cart

#### RegisterPage

Represents the user registration page with methods for:

- `enterFirstName()`: Enter first name
- `enterLastName()`: Enter last name
- `enterEmail()`: Enter email address
- `enterPassword()`: Enter password
- `enterConfirmPassword()`: Confirm password
- `clickCreateAccountButton()`: Click the create account button
- `register()`: Combined method to perform a complete registration

## Test Cases

The framework currently includes the following test cases:

### AddToCartTest

Tests the product search and add to cart functionality:

1. Search for "yoga pant"
2. Select the first product from search results
3. Select size "M" and color "Black"
4. Add the product to cart
5. Verify the success message

### LoginTest

Tests the user login functionality:

1. Navigate to the login page
2. Enter email and password
3. Click the sign-in button
4. Verify successful login

### RegistrationTest

Tests the user registration functionality:

1. Navigate to the registration page
2. Enter user details with a unique email
3. Submit the registration form
4. Verify the registration confirmation message

## Setup and Execution

### Prerequisites

- Java JDK 8 or higher
- Maven
- Chrome browser
- ChromeDriver (matching your Chrome version)

### Configuration

1. Update the ChromeDriver path in the test classes:

```java
System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
```

2. Update the test credentials in LoginTest.java for your Magento account.

### Running Tests

To run all tests:

```
mvn test
```

To run a specific test class:

```
mvn test -Dtest=LoginTest
```

## Best Practices Implemented

This framework implements several test automation best practices:

1. **Page Object Model**: Separation of page interactions from test logic
3. **Unique test data**: Using UUID to generate unique email addresses for registration
4. **Modular design**: Methods are small and focused on single responsibilities
5. **Proper assertions**: Clear assert messages to identify test failures


## Author

Edison Zyberaj
