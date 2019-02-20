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
