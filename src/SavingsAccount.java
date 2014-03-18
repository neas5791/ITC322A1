import ITC322A1.BaseAccount;

/**
 * A class representing ITC322 Assignment 1 Task 2
 * SavingsAccount. This class extends abstract class developed in 
 * Task 1 of this assignment. 
 * 
 * @see 	ChequeAccount
 * @author 	Sean Matkovich
 * @author  11187033
 * 
 */
public class SavingsAccount 
	extends BaseAccount implements Transaction
	{

	/** 
	 * Constructor, calls the superclass constructor,
	 * passing the string parameter owner. The super 
	 * class constructor generates unique account 
	 * number and zeroes balance.
	 * @param owner - String value of owners name
	 */
	public SavingsAccount(String owner) {
		super(owner);
	}

	/**
	 * Makes a deposit. Implementations will at least verify
     * the amount is positive before making the deposit.
     * @param amount the amount to deposit
     * @return true if positive amount deposited is realized as changes to balance of account; otherwise false.
	 */
	@Override
	public boolean deposit(double amount) {
		// Verifies amount is positive value
		if (amount >= 0) {
			this.balance += amount;
			return true;
		}
		System.out.println("You must enter a positive value!");
		return false;
	}

	
	/**
	 * Makes a withdrawal from the account balance.
	 * 
	 * <dt><b>Precondition: </b><dd>
	 * 				amount >= 0;
	 * 				<dd>balance >= amount;
	 * <dt><b>Postcondition: </b><dd>balance is reduced by amount.</dd>
	 * @param amount the amount to withdraw
	 * @return returns true if balance is adjusted.
	**/
	public boolean withdraw(double amount){
		// Verify amount is positive and sufficient balance  
		// is available to make withdrawal
		if ( (amount >= 0 ) && (this.balance >= amount) ){
			this.balance -= amount;
			return true;
		}
		return false;
	}
	
	/**
	 * Accept interest rate value
	 * 
	 * <dt><b>Precondition: </b><dd>
	 * 				interestRate >= 0;
	 * <dt><b>Postcondition: </b><dd>
	 * 				will increase the magnitude of the balance using 
	 * 				the interest rate.</dd>
	 * @param interestRate - is the positive amount that the balance will be adjusted by.
	 * @return returns true if balance is adjusted.
	**/
	public boolean addInterest(double interestRate){
		if (interestRate >= 0){
			this.balance += this.balance*(interestRate/100);
			return true;
		}
		return false;
	}

	/****************************************************/

	@Override
	public String toString() {
		return super.toString(); 
	}

}


/**
 * Overloaded constructor
 * Sets owner name and call base class constructor to set
 * name and balance at zero.
 * @param owner - String value of owners name
 *//*
public SavingsAccount(String owner, double balance) {
	super(owner,balance);
}
*/


/**
 * Compares this object with the specified object for order.  Returns a
 * negative integer, zero, or a positive integer as this object is less
 * than, equal to, or greater than the specified object.
 **
@Override
public int compareTo(BaseAccount o) {
	// uses the String compareTo method to 
	// return the relative position of the object
	return getOwner().compareTo(o.getOwner());
}*/

/**
 * Accepts cash  values for deposit
 * Checks the cash amount is positive calls the superclass setBalance(value)
 * to set new balance amount
 * @param cash - is the positive amount that the balance will be adjusted by.
 * @return - returns true if balance is adjusted. 
**/