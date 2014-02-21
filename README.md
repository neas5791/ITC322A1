ITC322 A1
=========

Task 1 (10 Marks)

Get a copy of the code for ABSTRACT BaseAccount.java class from the Resources folder on the CSU Interact ITC322 site and
COMPLETE the abstract class.

This will require IMPLEMENTING the single method of the COMPARABLE <T> INTERFACE and, to be perfectly strict, to make 
inherited equals() consistent with this. Points to note about the class are:

  o The class provides basic state and functionality needed by more specialized accounts.
  o All concrete subclasses will need to IMPLEMENT a deposit() method, whose implementation may differ from one subclass
    to another.
  o Any subclasses may implement a withdraw() method, but this has not been made a requirement as some accounts types 
    (e.g. home loan accounts) do not allow withdrawal.
  o The Comparable <T> interface is IMPLEMENTED (you must complete this) by making accounts comparable through 
    alphabetical ordering of owners? names. Use the compareTo() method of String for this.
  o The equals() method inherited from class Object is OVERRIDDEN (you must complete this) to be
    consistent with the compareTo() method.
  o A toString() method (you must complete this) returns a string representation of the object's state.
  o Account numbers are generated in such a way that all accounts will have a unique account number.
  o A double is used for the balance, which can cause unfortunate representational errors, but is sufficient for these
    exercises.
    
Task 2 (10 Marks)

Write a SavingsAccount class that EXTENDS BaseAccount to provide accounts with the following features:	

  o Savings accounts are constructed with a zero balance, for which a call to the superclass constructor suffices.
  o deposit() and withdraw() methods will accept an amount for the transaction and verify it as positive. The account
    balance will be adjusted appropriately for the amount of the transaction, except that a withdrawal can be made only
    if the account's balance is sufficient to cover it. Both methods return a boolean indicating the success or not of
    the transaction.
  o An addInterest() method accepts a double which represents the current interest rate. The method will increase the 
    magnitude of the balance using this interest rate and return a boolean indicating success or not. The transaction 
    fails if the interest rate is not positive.
    
Task 3 (10 Marks)

Write a ChequeAccount class that extends BaseAccount to provide accounts with the following
features:
  o Cheque accounts are constructed with a zero balance, for which a call to the superclass constructor suffices.
  o Cheque accounts also have a credit limit that specifies the maximum amount by which the account may be overdrawn. 
    This can be set to zero in the constructor but should be able to be reset at any time after the account is created, 
    by a method setCreditLimit(). The credit limit, as defined, must not be negative.
  o deposit() and withdraw() methods will accept an amount for the transaction and verify it as positive. As well as 
    adjusting the account balance appropriately for the amount of the transaction, a successful transaction will deduct
    $0.30 from the balance as a transaction charge. A successful transaction must not leave the account overdrawn.
    
Task 4 (10 Marks)

Complete the TestAccounts class (TestAccounts.java is in the Resources folder on the CSU Interact ITC322 site), which is
to create some cheque and savings accounts and test the classes you have written. Note the following points:

  o Some of the operations to be done in the loops apply only to particular subclasses of BaseAccount. For these you 
  will have to use the instanceof operator to make sure you have an object of the required class. Even if you have, you
  will still have to cast the reference down to that class so the compiler doesn’t see the operation as illegal.
  o You can sort the array of accounts by name using one of the overloaded sort() methods of java.util.Arrays.

