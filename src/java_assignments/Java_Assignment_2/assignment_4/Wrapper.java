import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

class Wrapper{
    static Integer changeToObject(int value)
    {
        Integer i=value;
       // System.out.println(i.getClass());
        return i;
    }
    static int changeToBasic(Integer i)
    {
        int value=i;
       // System.out.println(typeof ));
        return value;
    }
    static String changeToString(int v)
    {
        String s=new String(String.valueOf(v));
        return s;
    }
    static Integer stringToBasic(String s)
    {
        return Integer.parseInt(s);
    }
    static String objectToString(Integer i)
    {
        return i.toString();
    }
    public static void main (String args[]) {
        Scanner s=new Scanner(System.in);
        int ch;
        while(true)
        {
            System.out.println("\n\t1. Change int to object\n\t2. Change Object to int\n\t3. Change int to String\n\t4. Change String to int\n\t5. Change object to String\n\t6. Exit\nEnter your choice:");
            ch=s.nextInt();
            s.nextLine();
            switch(ch)
            {
                case 1:
                System.out.println("Enter the value of int:");
                Object obj=changeToObject(s.nextInt());
                System.out.println("Basic type int to Integer object=");
                System.out.println(obj);
                System.out.println("Type->"+obj.getClass());
                break;
                case 2:
                System.out.println("Enter the value of object:");
                int i=changeToBasic(s.nextInt());
                System.out.println("Basic type int value(adding 10 to check)=");
                System.out.println(i+10);
                break;
                case 3:
                System.out.println("Enter the value of int:");
                String st=changeToString(s.nextInt());
                st+="__added string to check";
                System.out.println("basic(int) to String->"+st);
                break;
                case 4:
                System.out.println("Enter the string:");
                Integer it=stringToBasic(s.nextLine());
                System.out.println("String to int(adding 10 to check)=");
                System.out.println(it+10);
                System.out.println("Type->"+it.getClass());
                break;
                case 5:
                System.out.println("Enter the value of object:");
                String str=objectToString(s.nextInt());
                str+="__added string to check";
                System.out.println("Object to String->"+str);
                break;
                default:
                System.exit(0);
            }
        }       
    }   
}