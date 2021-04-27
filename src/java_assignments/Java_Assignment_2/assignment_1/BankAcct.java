import java.util.*;
public class BankAcct{
    String accountNum;
    double amount;
    static int last_id=0;
    static double interest_rate=0;
    double interest;
    BankAcct()
    {
        accountNum=null;
    }
    BankAcct(Scanner s)
    {
        last_id+=1;
        Date d=new Date();
        int y = d.getYear() + 1900;
        String sr = String.format("%03d", last_id);
        accountNum = new String(y + sr);
        System.out.println("Enter the amount:-");
        amount = s.nextDouble();
        interest = amount*interest_rate/100;
        amount+=interest;
        s.nextLine();
        System.out.println("Account Successfully created!");
        System.out.println("Your Bank Account Number:-"+accountNum);
    }
    static void initialize_interest(Scanner s)
    {
        System.out.println("enter the initial interset rate:");
        interest_rate=s.nextDouble();
        s.nextLine();
    }
    static void setInterest(Scanner s)
    {
        System.out.println("enter the interset rate to change:");
        interest_rate = s.nextDouble();
        s.nextLine();
    }
    static void show_interest_rate()
    {
        System.out.println("Interest rate:-"+interest_rate);
    }
    double get_balance()
    {
        return amount;
    }
    double get_interest()
    {
        return interest;
    }
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        int ch;
        BankAcct b=new BankAcct();//=new BankAcct();
        while(true)
        {
            System.out.println("\n\t1. Create account\n\t2. Intialize Interest rate\n\t3. Change Interest rate\n\t4. Display Interest rate\n\t5. Get Balance\n\t6. Calculate Interest\n\t7. Exit");
            ch=s.nextInt();
            s.nextLine();
            switch(ch)
            {
                case 1:b=new BankAcct(s);
                       break;
                case 2:BankAcct.initialize_interest(s);
                        break;
                case 3:BankAcct.setInterest(s);
                break;
                case 4:BankAcct.show_interest_rate();
                break;
                case 5:
                if(b.accountNum!=null)
                {
                    System.out.println("Your bank account balance = "+b.get_balance());
                }
                else
                {
                    System.out.println("Create a account fisrt please!!");
                }
                break;
                case 6:
                if (b.accountNum != null) {
                    System.out.println("Your bank account Interest = " + b.get_interest());
                } else {
                    System.out.println("Create a account fisrt please!!");
                }
                break;
                default:System.exit(0);
            }
        }
    }
}