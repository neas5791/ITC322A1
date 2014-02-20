import java.util.UUID;

/**
 * A class that represents ITC322 Assignment 1 Task 1 
 * BaseAccount. This class is the abstract class the remainder of the 
 * Assignment tasks are based on.
 *  
 * @see		BaseAccount
 * @author 	Sean Matkovich #11187033
 *
 */
public abstract class BaseAccount implements Comparable<BaseAccount> {

	private String owner;
	private UUID id;
	private double balance;

	/**
	 *  Default constructor. This private constructor is called by  
	 *  overload constuctor's and ensures a unique id value is 
	 *  generated upon object creation 
	 */
	private BaseAccount(){
		// generates a universally unique identifier using the
		// java.util.UUID randomUUID() method 
		id = UUID.randomUUID();
	}
	
	/**
	 * Overloaded Constructor
	 * @param balance	This is the initial 
	 * 					balance of the account
	 */
	protected BaseAccount(double balance){
		this();
		this.balance = balance;
		// the below code appends the last four digits of the unique account number to 
		// owner attribute. Hence ensuring compareTo() does not issues a false object equivalence.
		this.owner = "no owner\t" + 
				getId().toString().substring(
						this.getId().toString().length() - 4, getId().toString().length());
	}	
	
	/**
	 * Overloaded Constructor
	 * @param owner		This is the String value
	 * 					for the owner of the account
	 */
	protected BaseAccount(String owner){
		// calls overloaded constructor and initializes
		// balance to zero dollars. Although i think i read that double are automatically initialized 
		// with a 0 as they are not nullable. need to read more???
		this(0);
		// sets object owner value
		this.owner = owner;
	}
	
	/**
	 * Overloaded Constructor
	 * @param owner		This is the String value
	 * 					for the owner of the account
	 * @param balance	This is the initial 
	 * 					balance of the account
	 */
	protected BaseAccount (String owner, double balance){
		this();
		this.owner = owner;
		this.balance = balance;
	}

	/**
	 * Getter for the string instance variable representing owner name  
	 * @return			String content of owner 
	 */
	public String getOwner(){
		return this.owner;
	}

	/**
	 * Getter for the string instance variable representing Account number
	 * @return 			String content of Account Number
	 */
	public String getId(){
		return id.toString();
	}

	/**
	 * Getter for the double instance variable representing balance
	 * @return			Value of balance
	 */
	public double getBalance(){
		return balance;
	}

	/**
	 * Modifies the current balance by amount passed in by cash parameter
	 * @param		value	The amount the balance will be adjusted by.
	 */
	protected void modifyBalance(double value){
			balance += value;
	}

	/**
	 * Setter for the string instance variable representing owner name
	 * @param	name	The account owners name
	 */
	protected void setOwner(String name){
		this.owner = name;
	}

	/**
	 * Comparable interface required method
	 * 
	 * Objects of BaseAccount type are compared based on the string value 
	 * in instance variable owner. 
	 */
	public int compareTo(BaseAccount obj){
		// Compares this object with the specified object for order. 
		// Returns a negative integer, zero, or a positive integer 
		// as this object is less than, equal to, or greater than the 
		// specified object. 
		return this.owner.compareTo(obj.getOwner());
	}
	
	/**
	 * Overrides the Object inherited method, uses the interface implements compareTo method to 
	 * evaluate object equality.
	 * @param	obj - an object with which this BaseAccount is compared
	 * @return	A return 
	 */
	public boolean equals(Object obj){
		// Check that obj actually refers to a BaseAccount object
		if (obj instanceof BaseAccount){
			// Object equality is based on results of the Comparable 
			// implementation's compareTo(Object obj) method.
			if (this.compareTo((BaseAccount) obj) == 0 ) 
				return true;
		}
		return false;
	}

	/**
	 * All derived classes must define this method
	 *     
	 * @param	cash	This is the amount of cash for depositing into the account
	 * @return	Successful transactions return true, unsuccessful transactions returns false
	 */
	abstract public boolean deposit(double cash);
	
	/**
	 * All derived classes must override this object inherited method toString()
	 * @returns 	String representation of the objects state.
	 */
	abstract public String toString();
}

