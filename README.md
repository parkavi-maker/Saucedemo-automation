# Sauce Demo Automation Testing

## Candidate Name

Parkavi S

---

# Project Overview

This project automates two test scenarios on the Sauce Demo application using Selenium WebDriver with Java.

Application URL:
https://www.saucedemo.com

Automation Framework:

* Java
* Selenium WebDriver
* Chrome Browser

---

# Test Scenarios Covered

## Scenario 1 – Valid Login and Checkout

### Objective

Verify that a standard user can successfully purchase products and complete the checkout process.

### Test Steps

1. Launch Sauce Demo application.
2. Login using:

   * Username: standard_user
   * Password: secret_sauce
3. Add the following products:

   * Sauce Labs Backpack
   * Sauce Labs Bike Light
4. Open shopping cart.
5. Verify selected products are present.
6. Click Checkout.
7. Enter customer information.
8. Complete the order.
9. Verify success message:
   "Thank you for your order!"

### Expected Result

Order should be completed successfully and confirmation message should be displayed.

---

## Scenario 2 – Locked User Login

### Objective

Verify that a locked user cannot log in to the application.

### Test Steps

1. Launch Sauce Demo application.
2. Login using:

   * Username: locked_out_user
   * Password: secret_sauce
3. Click Login.
4. Capture error message.

### Expected Result

Application should display:

Epic sadface: Sorry, this user has been locked out.

Project Structure

sauseDemo/

├── ValidCheckout.java

├── Lockeduser.java

├── screenshots/

│ ├── LoginPage.png

│ ├── ProductsAdded.png

│ ├── CartPage.png

│ ├── CheckoutInformation.png

│ ├── OrderSuccess.png

│ └── LockedUserError.png

└── README.md

How to Execute
Scenario 1
Run:
ValidCheckout.java
Expected Output:
Order completed successfully
________________________________________
Scenario 2
Run:
Lockeduser.java
Expected Output:
Flow 2 Passed
________________________________________
Assertions Used
Scenario 1
Verify products added to cart:
•	Sauce Labs Backpack
•	Sauce Labs Bike Light
Verify order success message:
Thank you for your order!
Scenario 2
Verify locked user error message:
Epic sadface: Sorry, this user has been locked out.
________________________________________
