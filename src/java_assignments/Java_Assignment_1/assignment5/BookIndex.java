//package java_assignments.assignment5;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

class BookIndex {
    public static void main(String[] args) {
        try {
            BufferedReader br;
            Scanner s=new Scanner(System.in);
            if (args.length == 0) {
                br = new BufferedReader(new InputStreamReader(System.in));
            } else {
                br = new BufferedReader(new FileReader(args[0]));
            }
            //String index_str = new Index(br).toString();
            
            System.out.println("enter word or phrase to search:-");
            String str=s.nextLine();
            Index idx=new Index(br);
            System.out.println(idx.occurences.get(str));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
