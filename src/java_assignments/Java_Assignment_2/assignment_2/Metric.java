//package Java_Assignment_2;
import java.util.*;
class Kilometer{
    protected double value;
    public Kilometer(double d){
        value=d;
    }
    double getValue(){
        return value;
    }
    public String toString()
    {
        return Double.toString(value);
    }
}
class Mile{
    protected double value;
    public Mile(double d)
    {
        value=d;
    }
    
    double getValue() {
        return value;
    }

    public String toString() {
        return Double.toString(value);
    }
}
public class Metric {
    Kilometer km;
    Mile ml;
    public Metric(Kilometer k) { 
        km = new Kilometer(k.getValue());
        ml=new Mile(k.getValue()/1.5);
        System.out.println(km+" Km in Mile =>"+ml);
    }

    public  Metric(Mile m) {
        ml = new Mile (m.getValue());
        km=new Kilometer(m.getValue()*1.5);
        System.out.println(ml+" mile in KM =>"+km);
    }

    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        int ch;
        Metric m;
        while(true)
        {
            System.out.println("\n\t1. Convert KM to Mile\n\t2. Convert Mile to KM\n\t3. Exit");
            ch=s.nextInt();
            //s.next();
            switch(ch)
            {
                case 1:
                System.out.println("Enter the value of Kilometer:-");
                Kilometer k=new Kilometer(s.nextDouble());
                m = new Metric(k);
                break;
                case 2:
                System.out.println("Enter the value of Mile:-");
                Mile ml = new Mile(s.nextDouble());
                m = new Metric(ml);
                break;
                case 3:
                System.exit(0);
            }
        }
    }
}
