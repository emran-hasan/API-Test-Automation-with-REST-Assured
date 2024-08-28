# API Test Automation with REST Assured

## Project Summary: 
With this automation, I have created a flow where the admin can login in create new agents and customers, and perform several CRUD actions for the users such as GET, and PUT methods. The customer can perform several transactions like sending money, depositing, withdrawing, and payment. 
and check your own balance and statement. Also, the agent can deposit money to a customer. Overall these testing scenarios cover various features, including user authentication, financial transactions, and user interactions within the application.

## Prerequisites:
 - Git
 - NodeJS (Latest LTS)
 - rest-assured
 - commons-configuration
 - You will need IntelliJ IDEA software installed on your machine to run the tests.

## How to Run the Tests?
- ``Clone this repository to your local machine. <repourl>``
- Open with Intellij.
- If IntelliJ IDEA doesn't automatically detect the project structure, you may need to open the project manually.
-  Open ``build.gradle`` folder, all folder files are created automatically.
-  Test the project

## Test Scenarios:
- Do Login by admin
- Create 2 new customers and an agent
- Give 2000 tk from System account to the newly created agent
- Deposit 1500 tk to a customer from the agent account
- Withdraw 500 tk by the customer to the agent
- Send money 500 tk to another customer
- Payment 100 tk to any merchant (e.g. 01686606905) by the recipient customer
- Check balance of the recipient customer

## Generating Allure Report
To run the test, execute the following command in the terminal to generate the Allure report:
- ``gradle clean test``
- `` allure generate allure-results --clean -output``
- ``allure serve allure-results``
- 
### Overview Report:
![Overview](https://github.com/user-attachments/assets/bbc7448e-7521-4b53-bd9b-febfc35b8400)

### Behaviors Report:
![Behaviors](https://github.com/user-attachments/assets/37c2ac77-29c4-4434-8f86-2b1999ad080c)


## Author:
``Md. Emran Hasan``
