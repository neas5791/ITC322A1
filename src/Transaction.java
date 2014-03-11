/**
 * The Transaction interface outlines the common methods that form the basis of 
 * Transaction requirements for BaseAccount class implementation. 
 * 
 * In relation to the assignment this interface seemed the most sensible way to 
 * apply common tasks to the derived BaseAccounts. I also freed me to simplify 
 * the method calls by using the polymorphism mechanics of casting the derived 
 * objects as Tramsactions in calling TestAccounts.
 * 
 * @see 	Transaction
 * @author 	Sean Matkovich
 * @author  11187033
 * 
 */
public interface Transaction {
	
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
	public boolean withdraw(double amount);
}
