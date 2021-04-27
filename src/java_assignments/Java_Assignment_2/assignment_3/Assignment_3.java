//package Java_Assignment_2.assignment_3;
import java.util.*;
public class Assignment_3 {
    // count number of "a"
    static public void count_A(String s)
    {
        int count = 0;
        s=s.toLowerCase();
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i)== 'a')
                count++;
        }
        System.out.println("Number of 'a' appeared in the string :-" + count);
    }
    
    // count the number of occurence "and"
    static public void countand(String s) {
        s=s.toLowerCase();
        StringTokenizer st = new StringTokenizer(s);
        int count = 0;
        while (st.hasMoreTokens()) {
            String s1 = new String(st.nextToken());
            if (s1.equals("and"))
                count++;
        }
        System.out.println("Number Of 'and' in the sentence :- " + count);
    }
    
    // method to check whether the String starts with The or not
    static public void checkstartwithThe(String s) {
        s = s.toLowerCase();
        if (s.startsWith("the"))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
    
    // to convert the string into a character array
    static public void convertToCharacterArray(String s) {
        char array[] = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]); // just print the characters of the array in different lines
        }
    }

    //to tokenize the string
    static public void tokenize (String s) {
        StringTokenizer st = new StringTokenizer(s, "@.");
        System.out.println ("Tokens :- ");
        while(st.hasMoreTokens()) {
            System.out.println (st.nextToken());
        }
    }
    
    public static void main (String args[]) {
        Scanner sc = new Scanner (System.in);
        String s = new String ();
        while(true) {
            int ch;
            System.out.print ("1. Enter a new String\n2. count number of a's\n3. count number of ands\n4. check start with 'The'\n5. Convert to character array\n6. Tokenize\n7. Exit\nEnter Choice :- ");
            ch = sc.nextInt();
            switch (ch) {
                case 1: Scanner sc1 = new Scanner (System.in);
                        System.out.print ("Enter the String :- ");
                        s = sc1.nextLine();
                        break;
                case 2: count_A(s);
                        break;
                case 3: countand(s);
                        break;
                case 4: checkstartwithThe(s); 
                        break;
                case 5: convertToCharacterArray(s);
                        break;
                case 6: tokenize(s);
                        break;
                default : System.exit(0);
                        break;             
            }
        }
    }
}
