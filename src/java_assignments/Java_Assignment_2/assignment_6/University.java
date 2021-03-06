import java.util.*;

//abstract class person to hold the basic details
abstract class Person {
    //necessary attributes
    protected String name;
    protected String phoneNumber;
    protected String email;
    protected class Address 
    {
         // inner class address to hold the address details
        protected int premiseNo;
        protected String street;
        protected String city;
        protected int pin;
        protected String state;

        public Address () {} 
        public Address (Scanner sc){ 
            System.out.print ("Enter the premise Number :- ");
                premiseNo = Integer.parseInt(sc.nextLine());
                System.out.print ("Enter the street Name :- ");
                street = sc.nextLine();
                System.out.print ("Enter the city Name :- ");
                city = sc.nextLine();
                System.out.print ("Enter the pin :- ");
                pin = Integer.parseInt(sc.nextLine());
                System.out.print ("Enter State Name :- ");
                state = sc.nextLine();
            }
            public void getData(Scanner sc)
            {
                System.out.print ("Enter the premise Number :- ");
                premiseNo = Integer.parseInt(sc.nextLine());
                System.out.print ("Enter the street Name :- ");
                street = sc.nextLine();
                System.out.print ("Enter the city Name :- ");
                city = sc.nextLine();
                System.out.print ("Enter the pin :- ");
                pin = Integer.parseInt(sc.nextLine());
                System.out.print ("Enter State Name :- ");
                state = sc.nextLine();
            }
            public void showData () {
                System.out.println ("Premise Number :- " + premiseNo);
                System.out.println ("Street Name :- " + street);
                System.out.println ("City Name :- " + city);
                System.out.println ("Pin Number :- " + pin);
                System.out.println ("State Name :- " + state);
            }
            //modifier functions 
            public void changePremiseNo (Scanner sc) {
            // Scanner sc = new Scanner (System.in);
                System.out.println ("Premise Number :- " + premiseNo);
                System.out.print ("Enter the new premise Number :- ");
                int s = sc.nextInt();
                premiseNo = s;
                System.out.println ("Premise Number changed sucessfully !");
            }
            public void changeStreet (Scanner sc) { //modify the street name
                //Scanner sc = new Scanner (System.in);
                System.out.println ("Street :- " + street);
                System.out.print ("Enter the new street name :- ");
                String s = sc.next();
                street = s;
                System.out.println ("Street Name changed sucessfully !");
            }
            public void changeCity (Scanner sc) {
                //Scanner sc = new Scanner (System.in);
                System.out.println ("City :- " + city);
                System.out.print ("Enter the new city name :- ");
                String s = sc.next();
                city = s;
                System.out.println ("City Name changed sucessfully !");
            }
            public void changePinNo (Scanner sc) {
                //Scanner sc = new Scanner (System.in);
                System.out.println ("Pin Number :- " + pin);
                System.out.print ("Enter the new pin Number :- ");
                int s = sc.nextInt();
                pin = s;
                System.out.println ("Pin Number changed sucessfully !");
            }
            public void changeState (Scanner sc) {
                //Scanner sc = new Scanner (System.in);
                System.out.println ("State :- " + state);
                System.out.print ("Enter the new State Name :- ");
                String s = sc.next();
                state = s;
                System.out.println ("State Name changed sucessfully !");
            }
        }
        protected Address ad=new Address();
        public void modifyAddress (Scanner sc) {//public api to modify the address of the individual
            int ch;
            //Scanner sc = new Scanner (System.in);
            System.out.print ("1. modify premise number\n2. modify street name\n3. modify city name\n4. modify pin number\n5. modify state name\nEnter Choice :- ");
            ch = sc.nextInt();

            switch (ch) {
                case 1: ad.changePremiseNo(sc);
                        break;
                case 2: ad.changeStreet(sc);
                        break;
                case 3: ad.changeCity(sc);
                        break;
                case 4: ad.changePinNo(sc);
                        break;
                case 5: ad.changeState(sc);
                        break;
                default : System.out.println ("Invalid choice!!");
            }
        }
    abstract public void showData (); //method to show the data ; to be defined later
}

//designing the class Student
class Student extends Person{
    protected int rollNumber;
    protected String courseOfStudy;
    protected static int last = 0;

    public void getData (Scanner sc) { //method to get the relevant Student details
        //Scanner sc = new Scanner(System.in);
        System.out.print ("Enter Name :- ");
        name = sc.nextLine();
        System.out.print ("Enter Phone Number :- ");
        phoneNumber = sc.nextLine();
        System.out.print ("Enter the email id :- ");
        email = sc.nextLine();
        System.out.println ("Enter the Basic Address Details :- ");
        ad.getData(sc);
        last += 1;
        rollNumber = last;
        System.out.print ("Enter Course of study :- ");
        courseOfStudy = sc.nextLine();
        System.out.println ("Data entry successful ! Roll Number generated :- " + rollNumber);
    }
    @Override
    public void showData () {
        System.out.println ("Student Name :- " + name);
        System.out.println ("Student Roll Number :- " +  rollNumber);
        System.out.println ("Course Of Study :- " + courseOfStudy);
        System.out.println ("Student's Phone Number :- " + phoneNumber);
        System.out.println ("Student email id :- " + email);
        System.out.println("Residential Address Details ------------ \n");
        ad.showData(); //show the student's resident address
    }
    public int getRoll () {return rollNumber;}
}

//designing the class Faculty
class Faculty extends Person{
    //adding the necessary attributes
    protected int employeeId;
    protected String department;
    protected String specialisation;
    protected static int last = 0;
    public void getData (Scanner sc) {
        //Scanner sc = new Scanner(System.in);
        System.out.print ("Enter Name :- ");
        name = sc.nextLine();
        System.out.print ("Enter Phone Number :- ");
        phoneNumber = sc.nextLine();
        System.out.print ("Enter the email id :- ");
        email = sc.nextLine();
        System.out.println ("Enter the Basic Address Details :- ");
        ad.getData(sc);
        last += 1;
        employeeId = last;
        System.out.print ("Enter Department :- ");
        department = sc.nextLine();
        System.out.println ("Enter field of specialisation :- ");
        specialisation = sc.nextLine();
        System.out.println ("Data entry successful ! emmployee Id generated :- " + employeeId);
    }
    //method to display the faculty data
    @Override
    public void showData () {
        System.out.println ("Faculty Name :- " + name);
        System.out.println ("Faculty employee Id :- " +  employeeId);
        System.out.println ("Department :- " + department);
        System.out.println ("Field Of Specialisation :- " + specialisation);
        System.out.println ("Faculty Phone Number :- " + phoneNumber);
        System.out.println ("Faculty email id :- " + email);

        System.out.println("Residential Address Details ------------ \n");
        ad.showData(); //show the student's resident address
    }
    //public method to get the faculty id
    public int getFacultyId() {return employeeId;}
 }

//designing the class university
public class University {
    //maintaining a list of students and faculties
    protected ArrayList <Student> studentlist = new ArrayList<Student> ();
    protected ArrayList<Faculty> facultylist = new ArrayList<Faculty> ();

    //public method to test the functionalities
    public void addFaculty (Scanner s) { //method to add faculty
        Faculty ft = new Faculty();
        ft.getData(s);
        facultylist.add(ft);
        System.out.println ("Faculty Added successfully !");
    }

    public void addStudent (Scanner s) { //method to add a student
        Student st = new Student ();
        st.getData(s);
        studentlist.add(st);
        System.out.println ("Student Added successfully !");
    
    }

    //method to display a faculty 
    public void showFaculty (int id) {
        boolean flag = false;
        for(int i = 0; i < facultylist.size(); i++) {
            if(facultylist.get(i).getFacultyId() == id){
                facultylist.get(i).showData();
                flag = true;
            }
        }
        if(!flag)
            System.out.println ("No Faculty with the given id exists !");
    }
     //method to display a student 
     public void showStudent (int id) {
        boolean flag = false;
        for(int i = 0; i < studentlist.size(); i++) {
            if(studentlist.get(i).getRoll() == id){
                studentlist.get(i).showData();
                flag = true;
            }
        }
        if(!flag)
            System.out.println ("No Student with the given id exists !");
    }
    //method to change the address of a faculty
    public void changeFacultyAddress(int id,Scanner sc) {
        for(int i = 0; i < facultylist.size(); i++) {
            if(facultylist.get(i).getFacultyId() == id) {
                facultylist.get(i).modifyAddress(sc);
                return;
            }
        }
        System.out.println ("No Faculty with the given id exists !");
    }
    //method to change the address of a student
    public void changeStudentAddress (int id,Scanner sc) {
        for(int i = 0; i < studentlist.size(); i++) {
            if(studentlist.get(i).getRoll() == id) {
                studentlist.get(i).modifyAddress(sc);
                return;
            }
        }
        System.out.println ("No Student with the given id exists !");
    }
    public static void main (String args[]) {
        University obj = new University();
        Scanner s = new Scanner(System.in);
        while(true) {
            System.out.print ("\n\t1. Add Student\n\t2. Add Faculty\n\t3. Show Student\n\t4. Show Faculty\n\t5. Change Student Address\n\t6. Change Faculty Address\n\t7. Exit\nEnter Choice :- ");
            int ch = s.nextInt();
            s.nextLine();   
            switch (ch) {
                case 1: obj.addStudent(s);
                        break;
                case 2: obj.addFaculty(s);
                        break;
                case 3: System.out.print ("Enter Student Roll Number :- ");
                        int roll = s.nextInt();
                        obj.showStudent(roll);
                        break;
                case 4: System.out.print ("Enter Faculty Id :- ");
                        int id = s.nextInt();
                        obj.showFaculty(id);
                        break;
                case 5: System.out.print ("Enter Student Roll Number :- ");
                        roll = s.nextInt();
                        obj.changeStudentAddress(roll,s);
                        break;
                case 6: System.out.print ("Enter Faculty Id :- ");
                        id = s.nextInt();
                        obj.changeFacultyAddress(id,s);
                        break;
                default : System.exit(0);
                        break;
            }
        }
    }
 } 