//import java.util.Arrays;
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

        for (i = 0; i < 5; i++) {
        	if (list[i] instanceof ChequeAccount)
        		((ChequeAccount) list[i]).setCreditLimit(50.0);
            /* Insert code setting 50.0 credit limits */
            System.out.println(list[i]);
        }
        
        System.out.println();
        for (i = 0; i < 5; i++) {
        	list[i].deposit(20.0);
            /* Insert code depositing 20.0 in each account */
            System.out.println(list[i]);
        }
        
        System.out.println();
        for (i = 0; i < 5; i++) {
        	if (list[i] instanceof SavingsAccount)
        		((SavingsAccount) list[i]).withdraw(25.0);
        	else if (list[i] instanceof ChequeAccount)
        		((ChequeAccount) list[i]).withdraw(25.0);
            /* Insert code withdrawing 25.0 from each account */
            System.out.println(list[i]);
        }
        
        System.out.println();
//        for (i = 0; i < 5; i++) {
  //          /* Insert code adding 8.0% interest as applicable */
    //        System.out.println(list[i]);
      //  }

//        /* Insert code to sort the accounts by owner's name */
  //      for (i = 0; i < 5; i++)
    //        System.out.println(list[i]);
    }

}

        
