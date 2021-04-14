import java.util.*;

class Parentheses {
    static boolean areBracketsBalanced(String expr) {
        Stack exp = new Stack();
        for (int i = 0; i < expr.length(); i++) {
            char x = expr.charAt(i);

            if (x == '(' || x == '[' || x == '{') {
                exp.push(x);
                continue;
            }
            if (exp.isEmpty())
                return false;
            char check;
            switch (x) {
            case ')':
                check = exp.pop();
                if (check == '{' || check == '[')
                    return false;
                break;

            case '}':
                check = exp.pop();
                if (check == '(' || check == '[')
                    return false;
                break;

            case ']':
                check = exp.pop();
                if (check == '(' || check == '{')
                    return false;
                break;
            }
        }
        return (exp.isEmpty());
    }
}

class Stack {
    static final int MAX = 1000;
    int top;
    char a[] = new char[MAX]; // Maximum size of Stack

    boolean isEmpty() {
        return (top < 0);
    }

    Stack() {
        top = -1;
    }
    boolean push(char x) {
        if (top >= (MAX - 1)) {
            System.out.println("Stack Overflow");
            return false;
        } else {
            a[++top] = x;
            return true;
        }
    }

    char pop() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        } else {
            char x = a[top--];
            return x;
        }
    }
}
public class Main{
    public static void main(String args[])
    { 
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println("Enter the expression-");
            String s = in.nextLine();
            boolean b = Parentheses.areBracketsBalanced(s);
            if (b) {
                System.out.println("brackets are balanced");
            } else {
                System.out.println("brackets are not balanced");
            }
            System.out.println("Do you want to continue? enter 0 to exit or 1 to continue");
            int i=in.nextInt();
            in.nextLine();
            if(i==0)
            {
                    System.exit(0);
            }
            else {
                continue;}
        }
    }
}

