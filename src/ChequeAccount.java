/**
 * A class representing ITC322 Assignment 1 Task 3
 * ChequeAccount. This class extends class developed in 
 * Task 1 of this assignment. 
 * 
 * @see 	ChequeAccount
 * @author 	Sean Matkovich
 * @author  11187033
 * 
 */
public class ChequeAccount 
	extends BaseAccount implements Transaction 
{
	private double creditLimit;
	private static double transactionFee = 0.3;
	
	/** 
	 * Constructor, calls the superclass constructor,
	 * passing the string parameter owner. The super 
	 * class constructor generates unique account 
	 * number and zeroes balance.
	 * @param owner - String value of owners name
	 */
	public ChequeAccount(String owner) {
		super(owner);
		this.creditLimit = 0;
	}

	/**
	 * Set allowable credit limit on account
	 * <dt><b>Precondition: </b><dd>
	 * 			limitAmount >= 0;</dd>
	 * <dt><b>Postcondition:</b><dd>
	 * 			creditLimit = limitAmount;</dd> 
	 * @param limitAmount - positive value that represent the credit limit of the account
	 * @return returns true if creditLimit is adjusted
	 */
	public boolean setCreditLimit(double limitAmount){
		if (limitAmount >= 0){
			this.creditLimit = limitAmount;
			return true;
		}
		return false;
		}
	
	/**
	 * Makes a deposit. 
	 * <dt><b>Precondition: </b><dd>
	 * 			amount >= 0;
	 * 
     * @param amount the amount to deposit
     * @return true if positive amount deposited is realized as changes to balance of account; otherwise false.
	 * 
	 */
	public boolean deposit(double amount) 
	{
		// verifies amount is positive
		if (amount >= 0){
			/* Given that each deposit bares a fee, it is possible
			 * that in cases where the amount is less than the transactionFee
			 * a deposit can effectively form a withdrawal. 
			 * Given withdrawals are subject to the creditLimit
			 * we need to check that sum of the balance, creditLimit and amount is
			 * greater than or equal to the transactionFee 
			 */
			if ( ( this.balance + this.creditLimit + amount ) >= transactionFee)
			{ 
				this.balance += (amount - transactionFee);
				return true;
			}
			else
			{
				System.out.println("Your deposit must be greater than or equal to " + transactionFee);
			}
		}

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
		if (amount >= 0){
			//System.out.printf("Amount including transaction fee is %s\n",totalWithdrawalAmount);
			
			// checks thats funds are available by adding the credit limit and the current balance
			// and comparing against the sum of the withdrawal amount and the transaction fee
			if ( (this.balance + this.creditLimit) >= (amount + transactionFee) ) {
				this.balance -= (amount + transactionFee);
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return String.format("%s\tCredit Limit: $\t%.2f", super.toString(), this.creditLimit);
	}

}
