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

	private String name;
	private UUID id;
	private double balance;

	/**
	 *  Default constructor. This private constructor is called by  
	 *  overload constuctor's and creates a unique id value upon  
	 *  new object creation. 
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
		this.name = "no name\t" + 
				getId().toString().substring(
						this.getId().toString().length() - 4, getId().toString().length());
	}	
	
	/**
	 * Overloaded Constructor
	 * @param owner		This is the String value
	 * 					for the owner of the account
	 */
	protected BaseAccount(String name){
		// calls overloaded constructor and initializes
		// balance to zero dollars. 
		// This balance value is automatically initialized to 
		// its default value (zero)
		
		this();
		// sets object owner value
		this.name = name;
	}
	
	/**
	 * Overloaded Constructor
	 * @param owner		This is the String value
	 * 					for the owner of the account
	 * @param balance	This is the initial 
	 * 					balance of the account
	 */
	protected BaseAccount (String name, double balance){
		this();
		this.name = name;
		this.balance = balance;
	}

	/**
	 * Getter for the string instance variable representing owner name  
	 * @return			String content of owner 
	 */
	public String getName(){
		return this.name;
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
	 * @param	name	The account name
	 * <dt><b>Postcondition:</b><dd>
	 *			Account name string value set. 
	 */
	protected void setName(String name){
		this.name = name;
	}

	/**
	 * Comparable interface required method. Objects of BaseAccount type are compared based on the string value 
	 * in instance variable owner.
	 * 
	 * @param	obj is an object of type BaseAccount
	 * @return	
	 * 			Returns a negative integer, zero, or a positive integer 
	 * 			as this object is less than, equal to, or greater than the 
	 * 			specified object.
	 *  
	 */
	public int compareTo(BaseAccount obj){
		// Compares this object with the specified object for order. 
		// Returns a negative integer, zero, or a positive integer 
		// as this object is less than, equal to, or greater than the 
		// specified object. 
		return this.name.compareTo(obj.getName());
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
	 * @param	cash	is the amount of money being deposited into the account
	 * @return	Successful transactions return true, unsuccessful transactions returns false
	 * <dt><b>Postcondition:</b><dd>
	 * 			The balance is incremented by amount passed in by the cash argument 
	 */
	abstract public boolean deposit(double cash);
	
	/**
	 * All derived classes must override this object inherited method toString()
	 * @returns 	String representation of the objects state.
	 */
	abstract public String toString();
}

