//import java.util.Arrays;
//import java.util.Collections;

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

        System.out.println("Set credit limits of accounts to 50.0");
        for (i = 0; i < 5; i++) {
            /* Insert code setting 50.0 credit limits */
        	if (list[i] instanceof ChequeAccount)
        		((ChequeAccount) list[i]).setCreditLimit(50.0);
            System.out.println(list[i]);
        }
        
        System.out.println("\nDeposit 20.0 in each account");
        for (i = 0; i < 5; i++) {
            /* Insert code depositing 20.0 in each account */
        	list[i].deposit(20.0);
            System.out.println(list[i]);
        }
        
        System.out.println("\nWithdraw 25.0 from each account");
        for (i = 0; i < 5; i++) {
        	/* Insert code withdrawing 25.0 from each account */
        	if (list[i] instanceof SavingsAccount){
        		if (((SavingsAccount) list[i]).withdraw(25.0))
        			System.out.println(list[i]);
        		else
        			System.out.println(list[i] + "\tInsufficient funds");
        	}
        	else if (list[i] instanceof ChequeAccount){
        		if(((ChequeAccount) list[i]).withdraw(25.0))
        			System.out.println(list[i]);
        		else
        			System.out.println(list[i] + "\tInsufficient funds");
        	}
        }
        
        System.out.println("\nAdd 8.0% interest to the accounts");
        /* Insert code adding 8.0% interest as applicable */
        for (i = 0; i < 5; i++) {
        	if(list[i] instanceof SavingsAccount)
        		((SavingsAccount)list[i]).addInterest(8.0);
        	System.out.println(list[i]);
        }
        
        System.out.println("\nSort accounts by name");
        /* Insert code to sort the accounts by owner's name */
        for (i = 0; i < 5; i++){
        	java.util.Arrays.sort(list);
            System.out.println(list[i]);
        }
    }
}

        
