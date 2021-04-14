import java.util.*;
public class Main{
    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        DeptList h = new DeptList();
        int ch = 0;
        //System.out.println("\tWelcome to " + name + " Shop");
        while (true) {
            System.out.print(
                    "\n\t1. Add Student\n\t2. Add marks of a student\n\t3. Sort student of a department by name\n\t4. Sort student of a department by ID\n\t5. Sort student of a department by marks\n\t6. Display All Students of all departments\n\t7. Remove Student by id\n\t8. Get Marksheeet of a student\n\t9.Number of student admitted\n\t10. Exit\n\tEnter Choice :-");
            ch = s.nextInt();
            s.nextLine();
            switch (ch) {
            case 1:
                h.addStudent(s);
                break;
            case 2:
                h.add_marks(s);
                break;
            case 3:
                h.sort_student_by_name(s);
                break;
            case 4:
                h.sort_student_by_roll(s);
                break;
            case 5:
                h.sort_student_by_marks(s);
                break;
            case 6:
                h.showDetails();
                break;
            case 7:
                h.remove_student(s);
                break;
            case 8:
                h.get_marksheet(s);
                break;
            case 9:
                System.out.println("Total student admitted->"+h.get_numberof_student());
                break;
            default:
                System.exit(0);
            }
    }
}}
//base student class
class Student {
    int roll;
    String name, course;
    Date adm_date;
    int marks[]=new int[5];
    int total=0;
    Student(int r,String n,String c)
    {
        roll=r;
        name =new String(n);
        course=new String(c);
        adm_date=new Date();
    }
    void get_marks(Scanner s)
    {
        for(int i=0;i<5;i++)
        {
            System.out.println("Enter score in subject "+(i+1)+"->");
            marks[i]=s.nextInt();
            total+=marks[i];
        }
        s.nextLine();
    }
    Date get_date() {
        return adm_date;
    }

    void show() {
        System.out.println("Roll-" + roll);
        System.out.println("Name-" + name + "\n" + "Course-" + course);
        System.out.println("Admission Date-" + adm_date);
        System.out.println("-----------------------------------------------------\n");
        for (int i = 0; i < 5; i++) {
            System.out.println("Subject " + i + "=> " + marks[i] + "\n");
        }
        System.out.println("Total marks-" + total);
    }
    
    void show_marksheet() {
        System.out.println("Roll-" + roll);
        System.out.println("Name-" + name + "\n" + "Course-" + course);
        System.out.println("-----------------------------------------------------\n");
        for (int i = 0; i < 5; i++) {
            System.out.println("Subject " + i + "=> " + marks[i] + "\n");
        }
        System.out.println("Total marks-" + total);
    }
}

// class StudentArray {
//     static int last_roll = 000;
//     ArrayList<Student> studentarr = new ArrayList<>();
//    void addStudents(String n, String c, int[] m) {
//         last_roll += 1;
//         Student ns = new Student(last_roll, n, c, m);
//         studentarr.add(ns);
//     }

//     void show_marksheet() {
//         for (int i = 0; i < last_roll; i++) {
//             studentarr.get(i).show();
//         }
//     }

//     void show_students_admission() {
//         System.out.println("the number of students who have taken admission->" + last_roll);
//     }
// }

class NewStudent extends Student {
    String department;
    String ID;
    private String generate_ID(int roll,String dept)
    {
        adm_date = new Date();
        int y = (adm_date.getYear() + 1900) % 100;
        String sr = String.format("%03d", roll);
        ID = new String(dept + y + sr);
        return ID;
    }
    public NewStudent(String dept,int r,String n, String c)
    {
        super(r,n,c);
        department=new String(dept);
        ID =generate_ID(r, dept);
        System.out.println("ID of the student id ->"+ID);
    }
    void show() {
        System.out.println("ID-" + ID);
        System.out.println("Roll-" + roll);
        System.out.println("Name-" + name + "\n" + "Course-" + course);
        System.out.println("Admission Date-" + adm_date);
    }
    void show_marksheet()
    {
        System.out.println("ID-" + ID);
        System.out.println("Roll-" + roll);
        System.out.println("Name-" + name + "\n" + "Course-" + course);
        System.out.println("-----------------------------------------------------\n");
        for (int i = 0; i < 5; i++) {
            System.out.println("Subject " + i + "\t" + marks[i] + "\n");
        }
        System.out.println("Total marks- \t" + total);
    }
    public static Comparator<NewStudent> StuNameComparator = new Comparator<NewStudent>() 
    {
        public int compare(NewStudent s1, NewStudent s2) {
        String StudentName1 = s1.name.toUpperCase();
        String StudentName2 = s2.name.toUpperCase();
        //ascending order
        return StudentName1.compareTo(StudentName2);
        }
    };
    public static Comparator<NewStudent> StuIDComparator = new Comparator<NewStudent>() {
        public int compare(NewStudent s1, NewStudent s2) {
            String StudentRoll1 = s1.ID.toUpperCase();
            String StudentRoll2 = s2.ID.toUpperCase();
            // ascending order
            return StudentRoll1.compareTo(StudentRoll2);
        }
    };
    public static Comparator<NewStudent> StuMarksComparator = new Comparator<NewStudent>() {
        public int compare(NewStudent s1, NewStudent s2) {
            return s1.total - s2.total;
        }
    };
}
class StudentList {
    static int last_roll;
    public ArrayList<NewStudent> studentarr = new ArrayList<>();
    String department;

    StudentList(String dept) {
        department = new String(dept);
        last_roll = 0;
    }
    public void addStudents(Scanner s) {
        last_roll += 1;
        System.out.println("Enter Student details->");
        System.out.println("Name->");
        String name=s.nextLine();
        System.out.println("Course Name->");
        String course = s.nextLine();
        NewStudent ns = new NewStudent(department,last_roll,name,course);
        studentarr.add(ns);
        Collections.sort(studentarr,NewStudent.StuNameComparator);
        System.out.println("Student added");
    }
    void get_marks(String id,Scanner s)
    {
        for (int i = 0; i < studentarr.size(); i++) {
            if (studentarr.get(i).ID.equals(id)) {
                studentarr.get(i).get_marks(s);
                return;
            }
        }
        System.out.println("Student not found");
    }
    void showStudents() {
        for (int i = 0; i < studentarr.size(); i++) {
            studentarr.get(i).show();
        }
    }
    void sort_student(int i)
    {
        switch (i)
        {
            case 0:
                Collections.sort(studentarr, NewStudent.StuNameComparator);
            case 1:
                Collections.sort(studentarr, NewStudent.StuIDComparator);
            case 2:
                Collections.sort(studentarr, NewStudent.StuMarksComparator);
        }
    }
    void remove_student(String Id) {
        for (int i = 0; i < studentarr.size(); i++) {
            if (studentarr.get(i).ID.equals(Id)) {
                studentarr.remove(i);
               // System.gc();
                return;
            }
        }
        System.out.println("Student not found");
    }
    void show_marksheet(String Id)
    {
        for (int i = 0; i < studentarr.size(); i++) {
            if (studentarr.get(i).ID.equals(Id)) {
                studentarr.get(i).show_marksheet();
                return;
            }
        }
        System.out.println("Student not found");
    }
}
class DeptList {
    private static int last = 0;
    ArrayList<StudentList> studentlist = new ArrayList<>();

    public void addStudent(Scanner s) {
        System.out.println("Enter department name->");
        String dept=s.nextLine();
        for (int i = 0; i < studentlist.size(); i++) {
            if (studentlist.get(i).department.equals(dept)) {
                studentlist.get(i).addStudents(s);
                return;
            }
        }
        StudentList stl = new StudentList(dept);
        stl.addStudents(s);
        studentlist.add(stl);
        last += 1;
    }

    public void showDetails() {
        for (int i = 0; i < studentlist.size(); i++) {
            System.out.println("\nDepartment->" + studentlist.get(i).department);
            studentlist.get(i).showStudents();
        }
    }
    public void remove_student(Scanner s) {
        System.out.println("Enter student id->");
        String id=s.nextLine();
        String st = id.substring(0, 4);
        st = st.toUpperCase();
        for (int i = 0; i < last; i++) {
            if (studentlist.get(i).department.equals(st)) {
                studentlist.get(i).remove_student(id);
                System.out.println("Student info deleted\n");
                return;
            }
        }
        System.out.println("Student not found\n");
    }
    void sort_student_by_name(Scanner s)
    {
        System.out.println("Enter department name to sort->");
        String name=s.nextLine().toUpperCase();
        for(int i = 0;i<studentlist.size();i++)
        {
            if(studentlist.get(i).department.equals(name))
            {
                studentlist.get(i).sort_student(0);
            }
        }
    }
    
    void sort_student_by_roll(Scanner s) {
        System.out.println("Enter department name to sort->");
        String name = s.nextLine().toUpperCase();
        for (int i = 0; i < studentlist.size(); i++) {
            if (studentlist.get(i).department.equals(name)) {
                studentlist.get(i).sort_student(1);
            }
        }
    }
    
    void sort_student_by_marks(Scanner s) {
        System.out.println("Enter department name to sort->");
        String name = s.nextLine().toUpperCase();
        for (int i = 0; i < studentlist.size(); i++) {
            if (studentlist.get(i).department.equals(name)) {
                studentlist.get(i).sort_student(2);
            }
        }
    }
    void get_marksheet(Scanner s)
    {
        System.out.println("Enter student id->");
        String id=s.nextLine();
        String st = id.substring(0, 4);
        st = st.toUpperCase();
        for (int i = 0; i < last; i++) {
            if (studentlist.get(i).department.equals(st)) {
                studentlist.get(i).show_marksheet(id);
                return;
            }
        }
        System.out.println("Student not found\n");
    }
    void add_marks(Scanner s)
    {
        System.out.println("Enter student id->");
        String id=s.nextLine();
        String st = id.substring(0, 4);
        st = st.toUpperCase();
        for (int i = 0; i < last; i++) {
            if (studentlist.get(i).department.equals(st)) {
                studentlist.get(i).get_marks(id,s);
                return;
            }
        }
        System.out.println("Student not found\n");
    }
    int get_numberof_student()
    {
        int total=0;
        for(int i=0;i<last;i++)
        {
            total+=studentlist.get(i).studentarr.size();
        }
        return total;
    }
}