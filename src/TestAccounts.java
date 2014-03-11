/**
 * A testing class used for instantiated ITC322 Assignment 1 
 * classes.
 * 
 * @see 	TestAccounts
 * @author 	ITC322 - Provided Implementation
 * @author  Sean Matkovich - Modified 
 * @author  11187033
 * 
 */
public class TestAccounts
{
    public static void main(String[] args)
    {
        BaseAccount[] list = new BaseAccount[5];

        list[0] = new SavingsAccount("Fred");
        list[1] = new ChequeAccount("Jim");
        list[2] = new ChequeAccount("Sue");
        list[3] = new SavingsAccount("Jim");
        list[4] = new SavingsAccount("Jill");

        int i;

        // In the following loops do NOT use your knowledge
        // of which member of list[] is of which type
        
        // Modified the 'for' loops to end at list[] array length

        System.out.println("Set credit limits of accounts to 50.0");
        for (i = 0; i < list.length; i++) {
            /* Insert code setting 50.0 credit limits */
        	// Only objects of ChequeAccount type have a credit limit
        	// finding instances of ChequeAccount as we iterate through the
        	// the loop
        	if (list[i] instanceof ChequeAccount)
        		((ChequeAccount) list[i]).setCreditLimit(50.0);
            System.out.println(list[i]);
        }
        
        System.out.println("\nDeposit 20.0 in each account");
        for (i = 0; i < list.length; i++) {
            /* Insert code depositing 20.0 in each account */
        	
        	// All derived class of BaseAccount have a deposit method 
        	list[i].deposit(20.0);
            System.out.println(list[i]);
        }
        
        System.out.println("\nWithdraw 25.0 from each account");
        for (i = 0; i < list.length; i++) {
        	/* Insert code withdrawing 25.0 from each account */
        	
        	// I have introduced an Transaction interface which implements a withdraw method;
        	// any class that implements this interface will therefore feature the required 
        	// withdraw method. The if statement filters objects of the interface type 
        	// the list item is then cast to a transaction type and the relevant method is called
        	// from within the derived object
        	if ( list[i] instanceof Transaction){
        		if (((Transaction) list[i]).withdraw(25.0))
        			System.out.println(list[i]);
        		else
        			System.out.println(list[i] + "\tInsufficient funds");
        	}	
        }
        
        System.out.println("\nAdd 8.0% interest to the accounts");
        /* Insert code adding 8.0% interest as applicable */
        for (i = 0; i < list.length; i++) {
        	// Only objects of SavingsAccount type have an addInterest method
        	// finding instances of SavingsAccount as we iterate through the
        	// the loop
        	if(list[i] instanceof SavingsAccount)
        		((SavingsAccount)list[i]).addInterest(8.0);
        	System.out.println(list[i]);
        }
        
        System.out.println("\nSort accounts by name");
        /* Insert code to sort the accounts by owner's name */
        
        // Using the java.util.Array.sort to output a sorted list 
        // of our declared BaseAccount array
        for (i = 0; i < list.length; i++){
        	java.util.Arrays.sort(list);
            System.out.println(list[i]);
        }
        
        // Check the equals method works correctly
        System.out.println("\nCheck the equals method works correctly");
        BaseAccount b = list[1];
        for (i = 0; i < list.length; i++){
        	System.out.printf("Compare new BaseAccount object to list[%s] = %s\n", i, b.equals(list[i]));
        }
    }
}

        
