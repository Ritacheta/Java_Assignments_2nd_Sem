//package assignment_5;
import java.util.*;
class Account{
    String name;
    String customer_id;
    double loan_amount, asked_amount, available;
    static final double credit_limit=10000.0;
    static final double credit_limit_priviledged = 20000.0;
    long phn_num;
    static int last_id=0;
    boolean privileged;
    ArrayList<Double> loans=new ArrayList<Double>();
    public static void show_credit_limit()
    {
        System.out.println("Normal Credit limit:-"+credit_limit);
        System.out.println("Priviledged Credit limit:-" + credit_limit_priviledged);
    }
    void get_data(Scanner sc)
    {
        //Scanner sc=new Scanner(System.in);
        System.out.println("Enter Name:-");
        name = sc.nextLine();
        System.out.print("Enter phone number :- ");
        phn_num = sc.nextLong();
        last_id+=1;
        Date d = new Date();
        int y = d.getYear() + 1900;
        String sr = String.format("%03d", last_id);
        customer_id = new String(y + sr);
        System.out.println("What type of user are you?\n 1. Priviledged \n 2. Normal");
        int ch=sc.nextInt();
        if(ch==1)
        {
            privileged=true;
            available=credit_limit_priviledged;
        }
        else
        {
            privileged=false;
            available=credit_limit;
        }
        loan_amount=0;
        System.out.println("Account successfully created!!\nCustomer ID:-"+customer_id);
        //sc.close();
    }
    void show_details()
    {
        System.out.println("Customer ID:-"+customer_id+"\nName:-"+name+"\nPhone Number:-"+phn_num);

    }
    
    public void showLoanDetails() {
        int sum = 0;
        System.out.println("\t Loan History");
        for (int i = 0; i < loans.size(); i++) {
            System.out.println(loans.get(i));
            sum += loans.get(i);
        }
        loan_amount=sum;
        if (privileged)
            System.out.println("Maximum Credit Limit Allowance " + credit_limit_priviledged);
        else
            System.out.println("Maximum Credit Limit Allowance " + credit_limit);
        System.out.println("Total Loan amount taken :- " +loan_amount );
        System.out.println("Loan amount available for issue :- " + available);
    }
    void get_loan(Scanner s)
    {
        System.out.println("Enter the loan amount");
        asked_amount=s.nextDouble();
        if(asked_amount>available)
        {
            System.out.println("you can't take loan of "+asked_amount+ " as your available loan can be taken = "+available);
            return;
        }
        loans.add(asked_amount);
        available-=asked_amount;
        System.out.println("Loan issued successfully!!");
    }
}
public class Bank {
    ArrayList<Account> list=new ArrayList<Account>();
    private int is_account_present(String id)
    {
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i).customer_id.equals(id))
            {
                return i;
            }
        }
        System.out.println("Account not found!!");
        return -1;
    }
    void creat_account(Scanner s)
    {
        Account a=new Account();
        a.get_data(s);
       // a.show_details();
        list.add(a);
    }
    void show_details(Scanner s)
    {
        System.out.println("enter customer ID:-");
        String id=s.nextLine();
        int i=is_account_present(id);
        if(i!=-1)
        {
            list.get(i).showLoanDetails();
            return;
        }
    }
    void show_loan_details(Scanner s)
    {
        System.out.println("enter customer ID:-");
        String id = s.nextLine();
        int i = is_account_present(id);
        if (i != -1) {
            list.get(i).showLoanDetails();;
            return;
        }
    }
    void get_loan(Scanner s)
    {
        System.out.println("enter customer ID:-");
        String id = s.nextLine();
        int i = is_account_present(id);
        if (i != -1) {
            list.get(i).get_loan(s);;
            return;
        }
    }
    public static void Show_credit()
    {
        Account.show_credit_limit();
    }
    public static void main(String args[])
    {
        int ch;
        Scanner s=new Scanner(System.in);
        Bank b=new Bank();
        while(true)
        {
            System.out.println("\n\t1. Create Account\n\t2. Show Account Details\n\t3. Show loan and available loan amount\n\t4. Get a Loan\n\t5. Show credit amount limit\n\t6. Exit\nEnter your choice");
            ch=s.nextInt();
            s.nextLine();
            switch(ch)
            {
                case 1:
                b.creat_account(s);
                break;
                case 2:
                b.show_details(s);
                break;
                case 3:
                b.show_loan_details(s);
                break;
                case 4:
                b.get_loan(s);
                break;
                case 5:
                Show_credit();
                break;
                default:
                System.exit(0);
            }
        }
    }
}
