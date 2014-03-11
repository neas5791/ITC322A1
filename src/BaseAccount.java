/**
 * An abstract class to represent a basic Bank Account
 * ITC322 Assignment 1 Task 1
 * 
 * @see 	BaseAccount
 * @author 	Sean Matkovich
 * @author  11187033
 * 
 */
public abstract class BaseAccount
    implements Comparable<BaseAccount>
{
    private static int nextAcctNumber = 1;
    protected String owner;
    protected int acctNumber;
    protected double balance;

    /**
     * Constructor, used only by subclasses, sets owner,
     * generates unique account number and zeroes balance.
     * @param name owner's name
     */
    protected BaseAccount(String name)
    {
        owner = name;
        acctNumber = nextAcctNumber++;
        balance = 0.0;
    }

    /**
     * Makes a deposit. Implementations will at least verify
     * the amount is positive before making the deposit.
     * @param amount the amount to deposit
     * @return true if amount is positive otherwise false
     */
    public abstract boolean deposit(double amount);

    /**
     * Implements the Comparable interface, making accounts
     * comparable through alphabetical ordering by owner's name.
     */
    public int compareTo(BaseAccount rhs)
    { 
    	/**
    	 * Compares this object with the specified object for order.
    	 * Returns a negative integer, zero, or a positive integer
	  	 * as this object is less than, equal to, or greater than the
	  	 * specified object. 
    	 */
    	
    	// In the event that the two account both have the same name
    	// we need to further check the account number (to ensure the equals method
    	// remains consistent.
    	if (this.owner.compareTo(rhs.owner) == 0){
    		if (this.acctNumber < rhs.acctNumber)
    			return -1;
    		else if (this.acctNumber > rhs.acctNumber)
    			return 1;
    		else
    			return 0;
    	}
    	
    	return this.owner.compareTo(rhs.owner);    	
    }

    /**
     * Override equals to be consistent with compareTo
     */
    public boolean equals(Object rhs)
    { 
    	// Check that rhs actually refers to a BaseAccount object
		if (rhs instanceof BaseAccount){
			// Object equality is based on results of the Comparable 
			// implementation's compareTo(Object rhs) method.
			if (this.compareTo((BaseAccount) rhs) == 0 ) 
				return true;
		}
		return false;
	}

    /**
     * @return String representation of the object
     */
    public String toString()
    {
    	return String.format("Name: %s\tAccount Number: %s\tBalance: $\t%.2f", this.owner, this.acctNumber, this.balance);
    } 
}
