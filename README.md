# Bank Tech Test

Banking Application, created with Java and JUnit (testing framework), using BDD, TDD and OOP principles.

## Requirements

- You should be able to interact with your code via a REPL like IRB or the JavaScript console. (You don't need to implement a command line interface that takes input from STDIN.)
- Deposits, withdrawal.
- Account statement (date, amount, balance) printing.
- Data can be kept in memory (it doesn't need to be stored to a database or anything).

## Acceptance Criteria

**Given** a client makes a **deposit** of 1000 on 10-01-2012 <br />
**And** a **deposit** of 2000 on 13-01-2012 <br />
**And** a **withdrawl** of 500 on 14-01-2012 <br />
**When** she **prints** her bank statement <br />
**Then** she would see: <br />

date || credit || debit || balance <br />
14/01/2012 || || 500.00 || 2500.00 <br />
13/01/2012 || 2000.00 || || 3000.00 <br />
10/01/2012 || 1000.00 || || 1000.00 <br />

## The Application

The project can be found here:
https://github.com/SecretSurfSpot/bank_tech_test_java

### Installation
- Clone the repo to your local machine:
`git clone https://github.com/SecretSurfSpot/bank_tech_test_java.git`

### Testing
To test the application:
- Open Terminal (or a similar command line interface)
- Run `gradle clean test` from the project root

The above commands result in the following output:
![Test Screenshot](https://github.com/SecretSurfSpot/bank_tech_test_java/blob/master/images/test_screenshot.png)

### Use
To use the application, open a Terminal in the project root and type:
- `jshell --class-path build/classes/java/main`

Within jshell, type:

(To create an instance of the Account, and make some transactions):
- `import main.java.Account;`
- `Account account = new Account();`
- `account.makeDeposit(1000.00);`
- `account.makeDeposit(2000.00);`
- `account.makeWithdrawal(500.00);`

(To create an instance of the Printer, and pass the transactions log to the printer to print the bank statement):
- `import main.java.Printer;`
- `Printer printer = new Printer();`
- `public ArrayList transactionLog = new ArrayList();`
- `transactionLog = account.transaction.returnTransactionLog();`
- `printer.printStatement(transactionLog);`

The above commands result in the following output:
![Interaction Screenshot](https://github.com/SecretSurfSpot/bank_tech_test_java/blob/master/images/interaction_screenshot.png)


## Domain Model

The model below illustrates the high-level structure of the application.

Three main objects (Classes):

1. **Account:** Takes inputs for both deposit and withdrawal amounts, keeps track of the balance and creates an instance of the Transactions class, which is passes relevant transaction details
2. **Transaction:** Takes inputs from the Account class and creates/updates the transactions log.
3. **Printer:** An independent stand alone class, which accepts an ArrayList as input and prints out a bank statement in the required format. (in the context of the Bank Tech Test solution, the Printer class method printStatement is passed the transactionLog returned by the Transaction class method returnTransactionLog)


```
    User
╔════════════╗  
║            ║ Interacts with application
║  Terminal  ║ via REPL, e.g. JShell    
║            ║
╚════════════╝
    |    |                       
    |    |     ╔════════════╗     
    |    |     ║            ║ public methods:  currentBalance, makeDeposit & makeWithdrawal
    |    |---->║  Account   ║        
    |          ║  (class)   ║ private methods: isAmountPositive           
    |          ╚════════════╝    
    |                |
    |                |      ╔════════════╗     
    |                |      ║            ║ public methods:  returnTransactionLog & addTransaction
    |                |----->║Transaction ║        
    |                       ║  (class)   ║         
    |                       ╚════════════╝    
    |
    |
    |
    V                             
╔════════════╗
║            ║ public methods:  printStatement
║   Printer  ║                  
║  (class)   ║ private methods: createBankStatement & addHeader
╚════════════╝            

```
