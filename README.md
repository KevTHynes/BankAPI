# BankAPI
A bank account application that allows a user to create accounts and withdraw, transfer and deposit funds as well as checking the current balance which updates automatically after a transaction. Created in Java with RESTful API and ArrayLists.
Solution Description
The solution description of this project is to create a RESTful API service which will have the implementation of an API allowing us to create a collection of java classes and methods which store the relevant data into in-memory objects such as ArrayLists. The Client side will allow the user to avail of the requirements listed with the creation of a HTML page which has the interface and ArrayLists to store the data.
Entity-Relationship Diagram


The RESTful API

1.	Create the customer
API Name: Create Customer
Description:This allows the user to create a profile in the bank so that later they can create accounts which will be linked to the customer profile and will allow the retrieval of resources belonging to that customer.
HTTP verb: POST
Parameters: Customer JSON object
Resource contents:
“Enter screenshot here”
 

This is a screenshot of all customers after the new customer had been added:
 

Pre-conditions No record for the customer with the specified customer_id must exist
Post-conditions: A new record for the user with the specified customer_id exists is stored in the customer arraylist object and is ready to set up an account.


2.	Get all customers back from the arraylist
API Name: getAllCustomers
Description:This allows the user to send a request to get all customers back which is stored in the ArrayList
HTTP verb: GET
Parameters: Null
Resource contents:
“Enter screenshot here”
 

Pre-conditions Null
Post-conditions: All customers which are stored in the customers ArrayList are returned via JSON object


3.	Get customer back from the ArrayList by Id
API Name: getCustomerId
Description:This allows the user to send a request to get a customer back which is stored in the ArrayList by its associate Id
HTTP verb: GET
Parameters: The path parameter is an Id, which specifies the specific Id for the customer
Resource contents: e.g. an example of a pf the returned resource
“Enter screenshot here” 
Pre-conditions Null
Post-conditions: The customer’s Id which are stored in the customers ArrayList is returned via JSON object


4.	Search for a customer back from the ArrayList by customer relavant values
API Name: getSearchCustomers
Description:This allows the user to send a request with an entered value to get a customer back which is stored in the ArrayList
HTTP verb: GET
Parameters: The path parameter is a value i.e. {name}, which specifies the specific value for the customers which has that value
Resource contents: e.g. an example of a pf the returned resource
“Enter screenshot here” 
Pre-conditions Null
Post-conditions: The customer’s which are stored in the customers ArrayList is returned via JSON object


5.	Request for an account belonging to a customer back from the ArrayList
API Name: getCustomerAccount
Description:This allows the user to send a request to get an account back by Id associated to the  customerId back with is stored in the ArrayList
HTTP verb: GET
Parameters: The path parameter is an Id belonging to a customer, and an accountId associated to that customer
Resource contents: e.g. an example of a pf the returned resource
“Enter screenshot here”
 

This is a call for a new account that was created for that same customer:
 

Pre-conditions Null
Post-conditions: The customer and the account requested, which are stored in the customers & accounts ArrayList is returned via JSON object

6.	Create an account for a customer
API Name: createAccount
Description:This allows the user to enter in their credentials which calls their customer profile then in return, creates a new account with current balance being ititialized as zero, account number and sort code generated and their account type i.e. “Savings account”. Which is then added to the list of accounts and linked to that specific customer
HTTP verb: POST
Parameters: The path parameter is a number of values i.e. customer’s email (String) and pin (int)
Resource contents: e.g. an example of a pf the returned resource
“Enter screenshot here”
 

This is a screenshot for all accounts for the same customer after new accoiunt was made:
 
Pre-conditions customer id must exist and no record of new account id for new account must exist
Post-conditions: The customer and its new account which are stored in the customers and accounts ArrayList is returned via JSON object


7.	Withdraw money from account
API Name: withdrawMoney
Description:This allows the user to send a request with an entered number to withdraw from an account belonging to the associated customer which returns the account with the updated balance after the account withdrawl.
HTTP verb: PUT
Parameters: The path parameter is a customer id (int) follwed by an acount id (int) and then the amount (int)
Resource contents: e.g. an example of a pf the returned resource
“Enter screenshot here”
 

This is a screenshot to demonstrate the account after the withdrawl was made:
 

Pre-conditions The customer must enter their id followed by its associated account id and specify the amount.
Post-conditions: The customer’s account will be debited after the money is taken out and the current balance will be updated while adding a new transaction to the accounts array detailing the withdrawl and most importantly having a post balance which correlates to the current balance in the account.


8.	Lodge money to account
API Name: lodgeMoney
Description:This allows the user to send a request with an entered number to lodge into an account belonging to the associated customer which returns the account with the updated balance after the account lodgement.
HTTP verb: PUT
Parameters: The path parameter is a customer id (int) follwed by an acount id (int) and then the amount (int)
Resource contents: e.g. an example of a pf the returned resource
“Enter screenshot here”
 
This is a screenshot to demonstrate the account after the lodgment had been made:
 

Pre-conditions The customer must enter their id followed by its associated account id and specify the amount.
Post-conditions: The customer’s account will be credited after the money is added and the current balance will be updated while adding a new transaction to the accounts array detailing the lodgement and most importantly having a post balance which correlates to the current balance in the account.


9.	Transfer money from account to an account
API Name: transferMoney
Description:This allows the user to send a request with an entered number to transfer from one account to anither belonging to the associated customer which returns the accounts with the updated balance, one being debited and the other being credited.
HTTP verb: PUT
Parameters: The path parameter is a customer id (int) follwed by an acount id (int) from the debited acount, an account id specifying the credited account (int) and then the amount (int)
Resource contents: e.g. an example of a pf the returned resource
“Enter screenshot here”

 

This is a screenshot of the accounts after the transfer was made:
 

Pre-conditions The customer must enter their valid id followed by its associated account id and the id of the account to be credited then specify the amount. All id’s must be valid and linked.
Post-conditions: The customer’s account will be debited after the money is taken out, the current balance will be updated while adding a new transaction to the accounts array, followed by the account specified for crediting will be credited the amount and the current balance will update with the current amount + the amount being credited, a new transaction added to the credited accounts array and most importantly having a post balance which correlates to the current balance in both accounts.


10.	Get all accounts back from the arraylist
API Name: getAllAccounts
Description:This allows the user to send a request to get all accounts back which is stored in the ArrayList
HTTP verb: GET
Parameters: Null
Resource contents: e.g. an example of a pf the returned resource
“Enter screenshot here”
 

Pre-conditions Null
Post-conditions: All accounts which are stored in the accounts ArrayList are returned via JSON object


11.	Get account back from the ArrayList by Id
API Name: getAccountsId
Description:This allows the user to send a request to get an account back which is stored in the ArrayList by its associate Id
HTTP verb: GET
Parameters: The path parameter is an Id (int), which specifies the specific Id for the account
Resource contents: e.g. an example of a pf the returned resource
“Enter screenshot here”
 

Pre-conditions Null
Post-conditions: The account Id which is stored in the accounts ArrayList is returned via JSON object


12.	Search for a account back from the ArrayList by account relavant values
API Name: getSearchAccounts
Description:This allows the user to send a request with an entered value to get an account back which is stored in the ArrayList. This can return all accounts back by the desired account type.
HTTP verb: GET
Parameters: The path parameter is a string i.e. {accountType} (String), which specifies the specific value for the accounts which has that string
Resource contents: e.g. an example of a pf the returned resource
“Enter screenshot here”
 

Pre-conditions Null
Post-conditions: The account ‘s with the associated account type given which are stored in the accounts ArrayList is returned via JSON object


13.	Request for a transaction belonging to an account back from the ArrayList
API Name: getAccountTransaction
Description:This allows the user to send a request to get a transaction back by Id associated to the accountId back wich is stored in the ArrayList
HTTP verb: GET
Parameters: The path parameter is an Id (int) belonging to an account, and a transactionId (int) associated to that account
Resource contents: e.g. an example of a pf the returned resource
“Enter screenshot here”
 

Pre-conditions Null
Post-conditions: The account and the transaction requested, which are stored in the accounts & transactions ArrayList is returned via JSON object


14.	Request the current balance in an account back from the ArrayList
API Name: getBalance
Description:This allows the user to send a request to get the current balance back associated to the account number which is stored in the ArrayList
HTTP verb: GET
Parameters: The path parameter is an account number (int) belonging to an account
Resource contents: e.g. an example of a pf the returned resource
“Enter screenshot here”

This is the account we are checking the balance for:
 

This is the request for the current balance:
 

Pre-conditions the account number entered must exist
Post-conditions: The current balance requested, which is stored in the accounts ArrayList is returned via JSON object


15.	Get all transactions back from the arraylist
API Name: getAllTransactions
Description:This allows the user to send a request to get all transactions back which is stored in the ArrayList
URI: http://localhost:49000/api/transactions
HTTP verb: GET
Parameters: Null
Resource contents: e.g. an example of a pf the returned resource
“Enter screenshot here”
 

Pre-conditions Null
Post-conditions: All transactions which are stored in the transactions ArrayList are returned via JSON object
